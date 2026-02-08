export default {
	baseUrl: 'http://localhost:8080/springboot1z11jbg7/',
	name: '/springboot1z11jbg7',
	indexNav: [
		{
			name: '养殖环境',
			url: '/index/yangzhihuanjing',
		},
		{
			name: '物品库存',
			url: '/index/wupinkucun',
		},
		{
			name: '疾病知识',
			url: '/index/jibingzhishi',
		},
		{
			name: '疾病预警',
			url: '/index/jibingyujing',
		},
		{
			name: '设备信息',
			url: '/index/shebeixinxi',
		},
		{
			name: '系统通知',
			url: '/index/news'
		},
	],
	cateList: [
		{
			name: '系统通知',
			refTable: 'newstype',
			refColumn: 'typename',
		},
	]
}
