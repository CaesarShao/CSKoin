package com.caesar.cskoin

import android.app.Application
import android.view.View
import com.caesar.cskoin.factory.Person
import com.caesar.cskoin.fragment.FragActivity
import com.caesar.cskoin.fragment.MyFragment
import com.caesar.cskoin.libmodule.ModuleData
import com.caesar.cskoin.normal.AppData
import com.caesar.cskoin.normal.NormalData
import com.caesar.cskoin.normal.ViewData
import com.caesar.cskoin.normal.WeatherData
import com.caesar.cskoin.other.ProData
import com.caesar.cskoin.other.TimeData
import com.caesar.cskoin.scope.ScopeCurentActivity
import com.caesar.cskoin.scope.ScopeData
import com.caesar.cskoin.scope.ScopeTypeTwo
import com.caesar.cskoin.single.UserData
import com.caesar.cskoin.viewmodel.MyViewModel
import com.caesarlib.koin.libModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin
import org.koin.core.qualifier.named
import org.koin.dsl.module

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            //开始启动koin
            androidContext(this@MyApp)//这边传Application对象,这样你注入的类中,需要app对象的时候,可以直接使用
            androidFileProperties()//默认名字为koin.properties,你也可以直接重新设置名称
//            fragmentFactory() //暂时2.1.0-alpha-3这个版本之前有问题,引用不到,估计作者还在调试,文档上的用法就是这样的
            modules(appModule, libModule.theLibModule)//这里面传各种被注入的模块对象,支持多模块注入,在2.0.1之后才支持vararg调用
        }
        loadKoinModules(otherModule)
    }

    val appModule = module {
        //里面添加各种注入对象
        factory {
            //普通的注入方式
            Person()
        }
        single {
            //单例的注入方式
            UserData()
        }
        viewModel {
            MyViewModel()
        }
        factory {
            AppData(get())
        }
        factory(named("nameAnum")) {
            //该限定符的构造方法中包含字符串和数字
            NormalData("曹老板", 12)
        }
        factory(named("app")) {
            //该限定符定义构造方法中有appliaction的
            NormalData(get<Application>())
        }
        factory(named("appData")) {
            //该限定符定义构造方法中有AppData的
            NormalData(get<AppData>())
        }
        factory(named("wea_name")) {
            WeatherData(get<NormalData>(named("nameAnum")))
            //这边get方法中有一个泛型,可以指定传入的对象的类型,因为我构造函数只有一个,所以会智能输入,可以省略掉
        }
        factory(named("wea_app")) {
            WeatherData(get(named("app")))//这边就智能省略掉泛型了
        }
        factory(named("wea_appData")) {
            WeatherData(get(named("appData")))
        }
        factory { (view: View) ->
            ViewData(view)//外部调用的方式,如果是多参数也一样,聪明的同学么应该要学会举一反三了
        }
        factory {
            ModuleData(get())
        }
        scope(named("myScope")) {
            //scope类型的注入方式一,通过标签的方式
            scoped {
                ScopeData()
            }
        }
        scope(named<ScopeCurentActivity>()) {
            scoped {
                ScopeTypeTwo()
            }
        }
        factory {
            ProData(getProperty("userName"))//该方法可以设置泛型对象,你已经是一个成熟的程序员了,要学会自己举一反三
        }

//        fragment { MyFragment("张三") }//暂时2.1.0-alpha-3这个版本之前有问题,引用不到,估计作者还在调试,文档上的用法就是这样的

        scope(named<FragActivity>()) {
            scoped {
                MyFragment("张三")
            }
        }
    }

    val otherModule = module {
        factory {
            TimeData(get())
        }

    }

}