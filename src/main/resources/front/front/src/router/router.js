import VueRouter from 'vue-router'
//引入组件
import Index from '../pages'
import Home from '../pages/home/home'
import Login from '../pages/login/login'
import Register from '../pages/register/register'
import Center from '../pages/center/center'
import Storeup from '../pages/storeup/list'
import News from '../pages/news/news-list'
import NewsDetail from '../pages/news/news-detail'
import payList from '../pages/pay'

import yonghuList from '../pages/yonghu/list'
import yonghuDetail from '../pages/yonghu/detail'
import yonghuAdd from '../pages/yonghu/add'
import yangzhihuanjingList from '../pages/yangzhihuanjing/list'
import yangzhihuanjingDetail from '../pages/yangzhihuanjing/detail'
import yangzhihuanjingAdd from '../pages/yangzhihuanjing/add'
import yangzhijihuaList from '../pages/yangzhijihua/list'
import yangzhijihuaDetail from '../pages/yangzhijihua/detail'
import yangzhijihuaAdd from '../pages/yangzhijihua/add'
import yangzhipinzhongList from '../pages/yangzhipinzhong/list'
import yangzhipinzhongDetail from '../pages/yangzhipinzhong/detail'
import yangzhipinzhongAdd from '../pages/yangzhipinzhong/add'
import wupinkucunList from '../pages/wupinkucun/list'
import wupinkucunDetail from '../pages/wupinkucun/detail'
import wupinkucunAdd from '../pages/wupinkucun/add'
import caigoujiluList from '../pages/caigoujilu/list'
import caigoujiluDetail from '../pages/caigoujilu/detail'
import caigoujiluAdd from '../pages/caigoujilu/add'
import touweirizhiList from '../pages/touweirizhi/list'
import touweirizhiDetail from '../pages/touweirizhi/detail'
import touweirizhiAdd from '../pages/touweirizhi/add'
import diaobojiluList from '../pages/diaobojilu/list'
import diaobojiluDetail from '../pages/diaobojilu/detail'
import diaobojiluAdd from '../pages/diaobojilu/add'
import kucunpandianList from '../pages/kucunpandian/list'
import kucunpandianDetail from '../pages/kucunpandian/detail'
import kucunpandianAdd from '../pages/kucunpandian/add'
import jibingzhishiList from '../pages/jibingzhishi/list'
import jibingzhishiDetail from '../pages/jibingzhishi/detail'
import jibingzhishiAdd from '../pages/jibingzhishi/add'
import jibingyujingList from '../pages/jibingyujing/list'
import jibingyujingDetail from '../pages/jibingyujing/detail'
import jibingyujingAdd from '../pages/jibingyujing/add'
import jibingbaogaoList from '../pages/jibingbaogao/list'
import jibingbaogaoDetail from '../pages/jibingbaogao/detail'
import jibingbaogaoAdd from '../pages/jibingbaogao/add'
import shebeileixingList from '../pages/shebeileixing/list'
import shebeileixingDetail from '../pages/shebeileixing/detail'
import shebeileixingAdd from '../pages/shebeileixing/add'
import shebeixinxiList from '../pages/shebeixinxi/list'
import shebeixinxiDetail from '../pages/shebeixinxi/detail'
import shebeixinxiAdd from '../pages/shebeixinxi/add'
import shebeicaigouList from '../pages/shebeicaigou/list'
import shebeicaigouDetail from '../pages/shebeicaigou/detail'
import shebeicaigouAdd from '../pages/shebeicaigou/add'
import shebeibaoxiuList from '../pages/shebeibaoxiu/list'
import shebeibaoxiuDetail from '../pages/shebeibaoxiu/detail'
import shebeibaoxiuAdd from '../pages/shebeibaoxiu/add'
import weixiujiluList from '../pages/weixiujilu/list'
import weixiujiluDetail from '../pages/weixiujilu/detail'
import weixiujiluAdd from '../pages/weixiujilu/add'
import shebeibaofeiList from '../pages/shebeibaofei/list'
import shebeibaofeiDetail from '../pages/shebeibaofei/detail'
import shebeibaofeiAdd from '../pages/shebeibaofei/add'
import xunjianjihuaList from '../pages/xunjianjihua/list'
import xunjianjihuaDetail from '../pages/xunjianjihua/detail'
import xunjianjihuaAdd from '../pages/xunjianjihua/add'
import syslogList from '../pages/syslog/list'
import syslogDetail from '../pages/syslog/detail'
import syslogAdd from '../pages/syslog/add'
import newstypeList from '../pages/newstype/list'
import newstypeDetail from '../pages/newstype/detail'
import newstypeAdd from '../pages/newstype/add'
import discussjibingzhishiList from '../pages/discussjibingzhishi/list'
import discussjibingzhishiDetail from '../pages/discussjibingzhishi/detail'
import discussjibingzhishiAdd from '../pages/discussjibingzhishi/add'

const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push(location) {
	return originalPush.call(this, location).catch(err => err)
}

//配置路由
export default new VueRouter({
	routes:[
		{
      path: '/',
      redirect: '/index/home'
    },
		{
			path: '/index',
			component: Index,
			children:[
				{
					path: 'home',
					component: Home
				},
				{
					path: 'center',
					component: Center,
				},
				{
					path: 'pay',
					component: payList,
				},
				{
					path: 'storeup',
					component: Storeup
				},
				{
					path: 'news',
					component: News
				},
				{
					path: 'newsDetail',
					component: NewsDetail
				},
				{
					path: 'yonghu',
					component: yonghuList
				},
				{
					path: 'yonghuDetail',
					component: yonghuDetail
				},
				{
					path: 'yonghuAdd',
					component: yonghuAdd
				},
				{
					path: 'yangzhihuanjing',
					component: yangzhihuanjingList
				},
				{
					path: 'yangzhihuanjingDetail',
					component: yangzhihuanjingDetail
				},
				{
					path: 'yangzhihuanjingAdd',
					component: yangzhihuanjingAdd
				},
				{
					path: 'yangzhijihua',
					component: yangzhijihuaList
				},
				{
					path: 'yangzhijihuaDetail',
					component: yangzhijihuaDetail
				},
				{
					path: 'yangzhijihuaAdd',
					component: yangzhijihuaAdd
				},
				{
					path: 'yangzhipinzhong',
					component: yangzhipinzhongList
				},
				{
					path: 'yangzhipinzhongDetail',
					component: yangzhipinzhongDetail
				},
				{
					path: 'yangzhipinzhongAdd',
					component: yangzhipinzhongAdd
				},
				{
					path: 'wupinkucun',
					component: wupinkucunList
				},
				{
					path: 'wupinkucunDetail',
					component: wupinkucunDetail
				},
				{
					path: 'wupinkucunAdd',
					component: wupinkucunAdd
				},
				{
					path: 'caigoujilu',
					component: caigoujiluList
				},
				{
					path: 'caigoujiluDetail',
					component: caigoujiluDetail
				},
				{
					path: 'caigoujiluAdd',
					component: caigoujiluAdd
				},
				{
					path: 'touweirizhi',
					component: touweirizhiList
				},
				{
					path: 'touweirizhiDetail',
					component: touweirizhiDetail
				},
				{
					path: 'touweirizhiAdd',
					component: touweirizhiAdd
				},
				{
					path: 'diaobojilu',
					component: diaobojiluList
				},
				{
					path: 'diaobojiluDetail',
					component: diaobojiluDetail
				},
				{
					path: 'diaobojiluAdd',
					component: diaobojiluAdd
				},
				{
					path: 'kucunpandian',
					component: kucunpandianList
				},
				{
					path: 'kucunpandianDetail',
					component: kucunpandianDetail
				},
				{
					path: 'kucunpandianAdd',
					component: kucunpandianAdd
				},
				{
					path: 'jibingzhishi',
					component: jibingzhishiList
				},
				{
					path: 'jibingzhishiDetail',
					component: jibingzhishiDetail
				},
				{
					path: 'jibingzhishiAdd',
					component: jibingzhishiAdd
				},
				{
					path: 'jibingyujing',
					component: jibingyujingList
				},
				{
					path: 'jibingyujingDetail',
					component: jibingyujingDetail
				},
				{
					path: 'jibingyujingAdd',
					component: jibingyujingAdd
				},
				{
					path: 'jibingbaogao',
					component: jibingbaogaoList
				},
				{
					path: 'jibingbaogaoDetail',
					component: jibingbaogaoDetail
				},
				{
					path: 'jibingbaogaoAdd',
					component: jibingbaogaoAdd
				},
				{
					path: 'shebeileixing',
					component: shebeileixingList
				},
				{
					path: 'shebeileixingDetail',
					component: shebeileixingDetail
				},
				{
					path: 'shebeileixingAdd',
					component: shebeileixingAdd
				},
				{
					path: 'shebeixinxi',
					component: shebeixinxiList
				},
				{
					path: 'shebeixinxiDetail',
					component: shebeixinxiDetail
				},
				{
					path: 'shebeixinxiAdd',
					component: shebeixinxiAdd
				},
				{
					path: 'shebeicaigou',
					component: shebeicaigouList
				},
				{
					path: 'shebeicaigouDetail',
					component: shebeicaigouDetail
				},
				{
					path: 'shebeicaigouAdd',
					component: shebeicaigouAdd
				},
				{
					path: 'shebeibaoxiu',
					component: shebeibaoxiuList
				},
				{
					path: 'shebeibaoxiuDetail',
					component: shebeibaoxiuDetail
				},
				{
					path: 'shebeibaoxiuAdd',
					component: shebeibaoxiuAdd
				},
				{
					path: 'weixiujilu',
					component: weixiujiluList
				},
				{
					path: 'weixiujiluDetail',
					component: weixiujiluDetail
				},
				{
					path: 'weixiujiluAdd',
					component: weixiujiluAdd
				},
				{
					path: 'shebeibaofei',
					component: shebeibaofeiList
				},
				{
					path: 'shebeibaofeiDetail',
					component: shebeibaofeiDetail
				},
				{
					path: 'shebeibaofeiAdd',
					component: shebeibaofeiAdd
				},
				{
					path: 'xunjianjihua',
					component: xunjianjihuaList
				},
				{
					path: 'xunjianjihuaDetail',
					component: xunjianjihuaDetail
				},
				{
					path: 'xunjianjihuaAdd',
					component: xunjianjihuaAdd
				},
				{
					path: 'syslog',
					component: syslogList
				},
				{
					path: 'syslogDetail',
					component: syslogDetail
				},
				{
					path: 'syslogAdd',
					component: syslogAdd
				},
				{
					path: 'newstype',
					component: newstypeList
				},
				{
					path: 'newstypeDetail',
					component: newstypeDetail
				},
				{
					path: 'newstypeAdd',
					component: newstypeAdd
				},
				{
					path: 'discussjibingzhishi',
					component: discussjibingzhishiList
				},
				{
					path: 'discussjibingzhishiDetail',
					component: discussjibingzhishiDetail
				},
				{
					path: 'discussjibingzhishiAdd',
					component: discussjibingzhishiAdd
				},
			]
		},
		{
			path: '/login',
			component: Login
		},
		{
			path: '/register',
			component: Register
		},
	]
})
