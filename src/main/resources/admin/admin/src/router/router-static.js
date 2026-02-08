import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
	import shebeibaoxiu from '@/views/modules/shebeibaoxiu/list'
	import weixiujilu from '@/views/modules/weixiujilu/list'
	import syslog from '@/views/modules/syslog/list'
	import kucunpandian from '@/views/modules/kucunpandian/list'
	import wupinkucun from '@/views/modules/wupinkucun/list'
	import discussjibingzhishi from '@/views/modules/discussjibingzhishi/list'
	import shebeileixing from '@/views/modules/shebeileixing/list'
	import yonghu from '@/views/modules/yonghu/list'
	import jibingyujing from '@/views/modules/jibingyujing/list'
	import jibingzhishi from '@/views/modules/jibingzhishi/list'
	import news from '@/views/modules/news/list'
	import touweirizhi from '@/views/modules/touweirizhi/list'
	import yangzhipinzhong from '@/views/modules/yangzhipinzhong/list'
	import shebeicaigou from '@/views/modules/shebeicaigou/list'
	import shebeixinxi from '@/views/modules/shebeixinxi/list'
	import yangzhihuanjing from '@/views/modules/yangzhihuanjing/list'
	import caigoujilu from '@/views/modules/caigoujilu/list'
	import chat from '@/views/modules/chat/list'
	import jibingbaogao from '@/views/modules/jibingbaogao/list'
	import diaobojilu from '@/views/modules/diaobojilu/list'
	import yangzhijihua from '@/views/modules/yangzhijihua/list'
	import xunjianjihua from '@/views/modules/xunjianjihua/list'
	import shebeibaofei from '@/views/modules/shebeibaofei/list'
	import config from '@/views/modules/config/list'
	import newstype from '@/views/modules/newstype/list'


//2.配置路由   注意：名字
export const routes = [{
	path: '/',
	name: '系统首页',
	component: Index,
	children: [{
		// 这里不设置值，是把main作为默认页面
		path: '/',
		name: '系统首页',
		component: Home,
		meta: {icon:'', title:'center', affix: true}
	}, {
		path: '/updatePassword',
		name: '修改密码',
		component: UpdatePassword,
		meta: {icon:'', title:'updatePassword'}
	}, {
		path: '/pay',
		name: '支付',
		component: pay,
		meta: {icon:'', title:'pay'}
	}, {
		path: '/center',
		name: '个人信息',
		component: center,
		meta: {icon:'', title:'center'}
	}
	,{
		path: '/shebeibaoxiu',
		name: '设备报修',
		component: shebeibaoxiu
	}
	,{
		path: '/weixiujilu',
		name: '维修记录',
		component: weixiujilu
	}
	,{
		path: '/syslog',
		name: '系统日志',
		component: syslog
	}
	,{
		path: '/kucunpandian',
		name: '库存盘点',
		component: kucunpandian
	}
	,{
		path: '/wupinkucun',
		name: '物品库存',
		component: wupinkucun
	}
	,{
		path: '/discussjibingzhishi',
		name: '疾病知识评论',
		component: discussjibingzhishi
	}
	,{
		path: '/shebeileixing',
		name: '设备类型',
		component: shebeileixing
	}
	,{
		path: '/yonghu',
		name: '用户',
		component: yonghu
	}
	,{
		path: '/jibingyujing',
		name: '疾病预警',
		component: jibingyujing
	}
	,{
		path: '/jibingzhishi',
		name: '疾病知识',
		component: jibingzhishi
	}
	,{
		path: '/news',
		name: '系统通知',
		component: news
	}
	,{
		path: '/touweirizhi',
		name: '投喂日志',
		component: touweirizhi
	}
	,{
		path: '/yangzhipinzhong',
		name: '养殖品种',
		component: yangzhipinzhong
	}
	,{
		path: '/shebeicaigou',
		name: '设备采购',
		component: shebeicaigou
	}
	,{
		path: '/shebeixinxi',
		name: '设备信息',
		component: shebeixinxi
	}
	,{
		path: '/yangzhihuanjing',
		name: '养殖环境',
		component: yangzhihuanjing
	}
	,{
		path: '/caigoujilu',
		name: '采购记录',
		component: caigoujilu
	}
	,{
		path: '/chat',
		name: '智能ai',
		component: chat
	}
	,{
		path: '/jibingbaogao',
		name: '疾病报告',
		component: jibingbaogao
	}
	,{
		path: '/diaobojilu',
		name: '调拨记录',
		component: diaobojilu
	}
	,{
		path: '/yangzhijihua',
		name: '养殖计划',
		component: yangzhijihua
	}
	,{
		path: '/xunjianjihua',
		name: '巡检计划',
		component: xunjianjihua
	}
	,{
		path: '/shebeibaofei',
		name: '设备报废',
		component: shebeibaofei
	}
	,{
		path: '/config',
		name: '轮播图管理',
		component: config
	}
	,{
		path: '/newstype',
		name: '系统通知分类',
		component: newstype
	}
	]
	},
	{
		path: '/login',
		name: 'login',
		component: Login,
		meta: {icon:'', title:'login'}
	},
	{
		path: '/register',
		name: 'register',
		component: register,
		meta: {icon:'', title:'register'}
	},
	{
		path: '*',
		component: NotFound
	}
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
	mode: 'hash',
	/*hash模式改为history*/
	routes // （缩写）相当于 routes: routes
})
const originalPush = VueRouter.prototype.push
//修改原型对象中的push方法
VueRouter.prototype.push = function push(location) {
	return originalPush.call(this, location).catch(err => err)
}
export default router;
