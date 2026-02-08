<template>
	<div class="home-content">
		<!-- title -->
		<div id="home-title" class="home-title animate__animated">
			<div class="titles" >
				<span>欢迎使用</span>
				{{this.$project.projectName}}
			</div>
		</div>
		<!-- statis -->
		<div class="statis-box">
			<div id="statis1" class="statis1 animate__animated" v-if="isAuth('yangzhihuanjing','首页总数')">
				<div class="left">
					<span class="icon iconfont icon-zhangjie8"></span>
				</div>
				<div class="right">
					<div class="num">{{yangzhihuanjingCount}}</div>
					<div class="name">养殖环境总数</div>
				</div>
			</div>
			<div id="statis2" class="statis2 animate__animated" v-if="isAuth('wupinkucun','首页总数')">
				<div class="left">
					<span class="icon iconfont icon-chujia3"></span>
				</div>
				<div class="right">
					<div class="num">{{wupinkucunCount}}</div>
					<div class="name">物品库存总数</div>
				</div>
			</div>
			<div id="statis3" class="statis3 animate__animated" v-if="isAuth('caigoujilu','首页总数')">
				<div class="left">
					<span class="icon iconfont icon-qita3"></span>
				</div>
				<div class="right">
					<div class="num">{{caigoujiluCount}}</div>
					<div class="name">采购记录总数</div>
				</div>
			</div>
			<div id="statis4" class="statis4 animate__animated" v-if="isAuth('touweirizhi','首页总数')">
				<div class="left">
					<span class="icon iconfont icon-liulan12"></span>
				</div>
				<div class="right">
					<div class="num">{{touweirizhiCount}}</div>
					<div class="name">投喂日志总数</div>
				</div>
			</div>
			<div id="statis5" class="statis5 animate__animated" v-if="isAuth('shebeixinxi','首页总数')">
				<div class="left">
					<span class="icon iconfont icon-chakan2"></span>
				</div>
				<div class="right">
					<div class="num">{{shebeixinxiCount}}</div>
					<div class="name">设备信息总数</div>
				</div>
			</div>
		</div>
		<!-- statis -->
	
		<!-- echarts -->
		<!-- 5 -->
		<div class="type5">
			<div id="yangzhihuanjingChart1" class="echarts1 animate__animated" v-if="isAuth('yangzhihuanjing','首页统计')"></div>
			<div id="wupinkucunChart1" class="echarts2 animate__animated" v-if="isAuth('wupinkucun','首页统计')"></div>
			<div id="caigoujiluChart1" class="echarts3 animate__animated" v-if="isAuth('caigoujilu','首页统计')"></div>
			<div id="touweirizhiChart1" class="echarts4 animate__animated" v-if="isAuth('touweirizhi','首页统计')"></div>
			<div id="shebeixinxiChart1" class="echarts5 animate__animated" v-if="isAuth('shebeixinxi','首页统计')"></div>
		</div>
	</div>
</template>
<script>
import 'animate.css'
//5
import router from '@/router/router-static'
import * as echarts from 'echarts'
export default {
	data() {
		return {
			yangzhihuanjingCount: 0,
			wupinkucunCount: 0,
			caigoujiluCount: 0,
			touweirizhiCount: 0,
			shebeixinxiCount: 0,
			line: {"backgroundColor":"transparent","yAxis":{"axisLabel":{"borderType":"solid","rotate":0,"padding":0,"shadowOffsetX":0,"margin":15,"backgroundColor":"transparent","borderColor":"#000","shadowOffsetY":0,"color":"#333","shadowBlur":0,"show":true,"inside":false,"ellipsis":"...","overflow":"none","borderRadius":0,"borderWidth":0,"width":"","fontSize":12,"lineHeight":24,"shadowColor":"transparent","fontWeight":"normal","height":""},"axisTick":{"show":true,"length":5,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#333","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"inside":false},"splitLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#666","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":true},"minInterval":1,"axisLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#333","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":true},"splitArea":{"show":false,"areaStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"rgba(25,25,25,0.3)","opacity":1,"shadowBlur":0,"shadowColor":"rgba(0,0,0,.5)"}}},"xAxis":{"axisLabel":{"borderType":"solid","rotate":0,"padding":0,"shadowOffsetX":0,"margin":4,"backgroundColor":"transparent","borderColor":"#000","shadowOffsetY":0,"color":"#333","shadowBlur":0,"show":true,"inside":false,"ellipsis":"...","overflow":"none","borderRadius":0,"borderWidth":0,"width":"","fontSize":12,"lineHeight":24,"shadowColor":"transparent","fontWeight":"normal","height":""},"axisTick":{"show":true,"length":5,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#333","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"inside":false},"splitLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#333","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":false},"axisLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#333","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":true},"splitArea":{"show":false,"areaStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"rgba(25,25,25,.3)","opacity":1,"shadowBlur":10,"shadowColor":"rgba(0,0,0,.5)"}}},"color":["#61c8b9","#00AD45","#72c794","#507AFC","#73c0de","#3ba272","#fc8452","#9a60b4","#ea7ccc"],"legend":{"padding":0,"itemGap":10,"shadowOffsetX":0,"backgroundColor":"transparent","borderColor":"#666","shadowOffsetY":0,"orient":"horizontal","shadowBlur":0,"bottom":"auto","itemHeight":14,"show":true,"icon":"roundRect","itemStyle":{"borderType":"solid","shadowOffsetX":0,"borderColor":"inherit","shadowOffsetY":0,"color":"#333","shadowBlur":0,"borderWidth":0,"opacity":1,"shadowColor":"transparent"},"right":"auto","top":"auto","borderRadius":0,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"inherit","shadowBlur":0,"width":"auto","type":"inherit","opacity":1,"shadowColor":"transparent"},"left":"right","borderWidth":0,"width":"80%","itemWidth":20,"textStyle":{"textBorderWidth":0,"color":"#333","textShadowColor":"transparent","ellipsis":"...","overflow":"none","fontSize":12,"lineHeight":24,"textShadowOffsetX":0,"textShadowOffsetY":0,"textBorderType":"solid","fontWeight":500,"textBorderColor":"transparent","textShadowBlur":0},"shadowColor":"rgba(0,0,0,.3)","height":"auto"},"series":{"showSymbol":true,"symbol":"arrow","symbolSize":8},"tooltip":{"backgroundColor":"#123","textStyle":{"color":"#fff"}},"title":{"borderType":"solid","padding":0,"shadowOffsetX":0,"backgroundColor":"transparent","borderColor":"#666","shadowOffsetY":0,"shadowBlur":0,"bottom":"auto","show":true,"right":"auto","top":"auto","borderRadius":0,"left":"left","borderWidth":0,"textStyle":{"textBorderWidth":0,"color":"#333","textShadowColor":"transparent","fontSize":14,"lineHeight":24,"textShadowOffsetX":0,"textShadowOffsetY":0,"textBorderType":"solid","fontWeight":600,"textBorderColor":"#666","textShadowBlur":0},"shadowColor":"transparent"}},
			bar: {"backgroundColor":"transparent","yAxis":{"axisLabel":{"borderType":"solid","rotate":0,"padding":0,"shadowOffsetX":0,"margin":12,"backgroundColor":"transparent","borderColor":"#666","shadowOffsetY":0,"color":"#333","shadowBlur":0,"show":true,"inside":false,"ellipsis":"...","overflow":"none","borderRadius":0,"borderWidth":0,"width":"","fontSize":12,"lineHeight":24,"shadowColor":"transparent","fontWeight":"normal","height":""},"axisTick":{"show":true,"length":5,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#333","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"inside":false},"splitLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#666","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":true},"minInterval":1,"axisLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#333","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":true},"splitArea":{"show":false,"areaStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"rgba(25,25,25,0.3)","opacity":1,"shadowBlur":10,"shadowColor":"rgba(0,0,0,.5)"}}},"xAxis":{"axisLabel":{"borderType":"solid","rotate":0,"padding":0,"shadowOffsetX":0,"margin":4,"backgroundColor":"transparent","borderColor":"#000","shadowOffsetY":0,"color":"#333","shadowBlur":0,"show":true,"inside":false,"ellipsis":"...","overflow":"none","borderRadius":0,"borderWidth":0,"width":"","fontSize":12,"lineHeight":24,"shadowColor":"transparent","fontWeight":"normal","height":""},"axisTick":{"show":true,"length":5,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#333","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"inside":false},"splitLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#333","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":false},"axisLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#333","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":true},"splitArea":{"show":false,"areaStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"rgba(25,25,25,.3)","opacity":1,"shadowBlur":10,"shadowColor":"rgba(0,0,0,.5)"}}},"color":["#61c8b9","#00AD45","#72c794","#507AFC","#73c0de","#3ba272","#fc8452","#9a60b4","#ea7ccc"],"legend":{"padding":0,"itemGap":10,"shadowOffsetX":0,"backgroundColor":"transparent","borderColor":"#666","shadowOffsetY":0,"orient":"horizontal","shadowBlur":0,"bottom":"auto","itemHeight":14,"show":true,"icon":"roundRect","itemStyle":{"borderType":"solid","shadowOffsetX":0,"borderColor":"inherit","shadowOffsetY":0,"color":"#333","shadowBlur":0,"borderWidth":0,"opacity":1,"shadowColor":"transparent"},"right":"auto","top":"auto","borderRadius":0,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"inherit","shadowBlur":0,"width":"auto","type":"inherit","opacity":1,"shadowColor":"transparent"},"left":"right","borderWidth":0,"width":"80%","itemWidth":20,"textStyle":{"textBorderWidth":0,"color":"inherit","textShadowColor":"transparent","ellipsis":"...","overflow":"none","fontSize":12,"lineHeight":12,"textShadowOffsetX":0,"textShadowOffsetY":0,"textBorderType":"solid","fontWeight":500,"textBorderColor":"transparent","textShadowBlur":0},"shadowColor":"rgba(0,0,0,.3)","height":"auto"},"series":{"barWidth":"auto","itemStyle":{"borderType":"solid","shadowOffsetX":2,"borderColor":"#666","shadowOffsetY":0,"color":"","shadowBlur":4,"borderWidth":0,"opacity":1,"shadowColor":"#aaa"},"colorBy":"data","barCategoryGap":"20%"},"tooltip":{"backgroundColor":"#123","textStyle":{"color":"#fff"}},"title":{"borderType":"solid","padding":0,"shadowOffsetX":0,"backgroundColor":"transparent","borderColor":"#666","shadowOffsetY":0,"shadowBlur":0,"bottom":"auto","show":true,"right":"auto","top":"auto","borderRadius":0,"left":"left","borderWidth":0,"textStyle":{"textBorderWidth":0,"color":"#333","textShadowColor":"transparent","fontSize":14,"lineHeight":24,"textShadowOffsetX":0,"textShadowOffsetY":0,"textBorderType":"solid","fontWeight":600,"textBorderColor":"#666","textShadowBlur":0},"shadowColor":"transparent"},"base":{"animate":false,"interval":2000}},
			pie: {"tooltip":{"backgroundColor":"#123","textStyle":{"color":"#fff"}},"backgroundColor":"transparent","color":["#61c8b9","#00AD45","#72c794","#507AFC","#73c0de","#3ba272","#fc8452","#9a60b4","#ea7ccc"],"title":{"borderType":"solid","padding":0,"shadowOffsetX":0,"backgroundColor":"transparent","borderColor":"#666","shadowOffsetY":0,"shadowBlur":0,"bottom":"auto","show":true,"right":"auto","top":"auto","borderRadius":0,"left":"left","borderWidth":0,"textStyle":{"textBorderWidth":0,"color":"#333","textShadowColor":"transparent","fontSize":14,"lineHeight":14,"textShadowOffsetX":0,"textShadowOffsetY":0,"textBorderType":"solid","fontWeight":600,"textBorderColor":"#666","textShadowBlur":0},"shadowColor":"transparent"},"legend":{"padding":[2,0,0,0],"itemGap":10,"shadowOffsetX":0,"backgroundColor":"transparent","borderColor":"#666","shadowOffsetY":0,"orient":"horizontal","shadowBlur":0,"bottom":"auto","itemHeight":12,"show":true,"icon":"roundRect","itemStyle":{"borderType":"solid","shadowOffsetX":0,"borderColor":"inherit","shadowOffsetY":0,"color":"inherit","shadowBlur":0,"borderWidth":0,"opacity":1,"shadowColor":"transparent"},"right":0,"top":"auto","borderRadius":0,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"inherit","shadowBlur":0,"width":"auto","type":"inherit","opacity":1,"shadowColor":"transparent"},"left":"right","borderWidth":0,"width":"80%","itemWidth":22,"textStyle":{"textBorderWidth":0,"color":"inherit","textShadowColor":"transparent","ellipsis":"...","overflow":"none","fontSize":12,"lineHeight":12,"textShadowOffsetX":0,"textShadowOffsetY":0,"textBorderType":"solid","fontWeight":500,"textBorderColor":"transparent","textShadowBlur":0},"shadowColor":"rgba(0,0,0,.3)","height":"auto"},"series":{"itemStyle":{"borderType":"solid","shadowOffsetX":0,"borderColor":"#fff","shadowOffsetY":0,"color":"","shadowBlur":0,"borderWidth":2,"opacity":1,"shadowColor":"#000"},"label":{"borderType":"solid","rotate":0,"padding":0,"textBorderWidth":0,"backgroundColor":"transparent","borderColor":"#666","color":"inherit","show":true,"textShadowColor":"transparent","distanceToLabelLine":5,"ellipsis":"...","overflow":"none","borderRadius":0,"borderWidth":0,"fontSize":12,"lineHeight":18,"textShadowOffsetX":0,"position":"outside","textShadowOffsetY":0,"textBorderType":"solid","textBorderColor":"#666","textShadowBlur":0},"labelLine":{"show":true,"length":10,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"#666","shadowBlur":0,"width":2,"type":"solid","opacity":1,"shadowColor":"#000"},"length2":14,"smooth":false}}},
			funnel: {"tooltip":{"backgroundColor":"#123","textStyle":{"color":"#fff"}},"backgroundColor":"transparent","color":["#61c8b9","#00AD45","#72c794","#507AFC","#73c0de","#3ba272","#fc8452","#9a60b4","#ea7ccc"],"title":{"borderType":"solid","padding":2,"shadowOffsetX":0,"backgroundColor":"transparent","borderColor":"#ccc","shadowOffsetY":0,"shadowBlur":0,"bottom":"auto","show":true,"right":"auto","top":"auto","borderRadius":0,"left":"center","borderWidth":0,"textStyle":{"textBorderWidth":0,"color":"#666","textShadowColor":"transparent","fontSize":14,"lineHeight":12,"textShadowOffsetX":0,"textShadowOffsetY":0,"textBorderType":"solid","fontWeight":500,"textBorderColor":"#ccc","textShadowBlur":0},"shadowColor":"transparent"},"legend":{"padding":5,"itemGap":10,"shadowOffsetX":0,"backgroundColor":"transparent","borderColor":"#ccc","shadowOffsetY":0,"orient":"vertical","shadowBlur":0,"bottom":"auto","itemHeight":2,"show":true,"icon":"roundRect","itemStyle":{"borderType":"solid","shadowOffsetX":0,"borderColor":"inherit","shadowOffsetY":0,"color":"inherit","shadowBlur":0,"borderWidth":0,"opacity":1,"shadowColor":"transparent"},"top":"auto","borderRadius":0,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"inherit","shadowBlur":0,"width":"auto","type":"inherit","opacity":1,"shadowColor":"transparent"},"left":"left","borderWidth":0,"width":"auto","itemWidth":2,"textStyle":{"textBorderWidth":0,"color":"inherit","textShadowColor":"transparent","ellipsis":"...","overflow":"none","fontSize":12,"lineHeight":20,"textShadowOffsetX":0,"textShadowOffsetY":0,"textBorderType":"solid","fontWeight":500,"textBorderColor":"transparent","textShadowBlur":0},"shadowColor":"rgba(0,0,0,.3)","height":"auto"},"series":{"itemStyle":{"borderType":"solid","shadowOffsetX":0,"borderColor":"#000","shadowOffsetY":0,"color":"","shadowBlur":2,"borderWidth":2,"opacity":1,"shadowColor":"#fff"},"label":{"borderType":"solid","rotate":0,"padding":0,"textBorderWidth":0,"backgroundColor":"transparent","borderColor":"#fff","color":"","show":true,"textShadowColor":"transparent","distanceToLabelLine":5,"ellipsis":"...","overflow":"none","borderRadius":0,"borderWidth":0,"fontSize":12,"lineHeight":18,"textShadowOffsetX":0,"position":"outside","textShadowOffsetY":0,"textBorderType":"solid","textBorderColor":"#fff","textShadowBlur":0},"labelLine":{"show":true,"length":10,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"#000"},"length2":14,"smooth":false}}},
			boardBase: {"funnelNum":8,"lineNum":8,"gaugeNum":8,"barNum":8,"pieNum":8},
			gauge: {"tooltip":{"backgroundColor":"#123","textStyle":{"color":"#fff"}},"backgroundColor":"transparent","color":["#61c8b9","#00AD45","#72c794","#507AFC","#73c0de","#3ba272","#fc8452","#9a60b4","#ea7ccc"],"title":{"top":"top","left":"left","textStyle":{"fontSize":14,"lineHeight":24,"color":"#333","fontWeight":600}},"series":{"pointer":{"offsetCenter":[0,"10%"],"icon":"path://M2.9,0.7L2.9,0.7c1.4,0,2.6,1.2,2.6,2.6v115c0,1.4-1.2,2.6-2.6,2.6l0,0c-1.4,0-2.6-1.2-2.6-2.6V3.3C0.3,1.9,1.4,0.7,2.9,0.7z","width":8,"length":"80%"},"axisLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"opacity":0.5,"shadowBlur":1,"shadowColor":"#000"},"roundCap":true},"anchor":{"show":true,"itemStyle":{"color":"inherit"},"size":18,"showAbove":true},"emphasis":{"disabled":false},"progress":{"show":true,"roundCap":true,"overlap":true},"splitNumber":25,"detail":{"formatter":"{value}","backgroundColor":"inherit","color":"#000","borderRadius":3,"width":20,"fontSize":12,"height":10},"title":{"fontSize":14},"animation":true}},
		};
	},
	mounted(){
		this.init();
		this.getyangzhihuanjingCount();
		if(this.isAuth('yangzhihuanjing','首页统计')){
			this.yangzhihuanjingChat1();
		}
		this.getwupinkucunCount();
		if(this.isAuth('wupinkucun','首页统计')){
			this.wupinkucunChat1();
		}
		this.getcaigoujiluCount();
		if(this.isAuth('caigoujilu','首页统计')){
			this.caigoujiluChat1();
		}
		this.gettouweirizhiCount();
		if(this.isAuth('touweirizhi','首页统计')){
			this.touweirizhiChat1();
		}
		this.getshebeixinxiCount();
		if(this.isAuth('shebeixinxi','首页统计')){
			this.shebeixinxiChat1();
		}
		window.addEventListener('scroll', this.handleScroll)
		setTimeout(()=>{
			this.handleScroll()
		},100)
	},
	computed: {
		avatar(){
			return this.$storage.get('headportrait')?this.$storage.get('headportrait'):''
		},
	},
	methods:{
		handleScroll() {
			let arr = [
				{id:'home-title',css:'animate__fadeInUp'},
				{id:'statis1',css:'animate__fadeInLeft'},
				{id:'statis2',css:'animate__fadeInLeftBig'},
				{id:'statis3',css:'animate__fadeInDown'},
				{id:'statis4',css:'animate__fadeInRight'},
				{id:'statis5',css:'animate__fadeInRightBig'},
				{id:'yangzhihuanjingChart1',css:'animate__fadeInUp'},
				{id:'wupinkucunChart1',css:'animate__fadeInUp'},
				{id:'caigoujiluChart1',css:'animate__fadeInUp'},
				{id:'touweirizhiChart1',css:'animate__fadeInUp'},
				{id:'shebeixinxiChart1',css:'animate__fadeInUp'},
			]
			
			for (let i in arr) {
				let doc = document.getElementById(arr[i].id)
				if (doc) {
					let top = doc.offsetTop
					let win_top = window.innerHeight + window.pageYOffset
					// console.log(top,win_top)
					if (win_top > top && doc.classList.value.indexOf(arr[i].css) < 0) {
						// console.log(doc)
						doc.classList.add(arr[i].css)
					}
				}
			}
		},
		// 统计图动画
		myChartInterval(type, xAxisData, seriesData, myChart) {
			this.$nextTick(() => {
				setInterval(() => {
					let xAxis = xAxisData.shift()
					xAxisData.push(xAxis)
					let series = seriesData.shift()
					seriesData.push(series)
				
					if (type == 1) {
						myChart.setOption({
							xAxis: [{
								data: xAxisData
							}],
							series: [{
								data: seriesData
							}]
						});
					}
					if (type == 2) {
						myChart.setOption({
							yAxis: [{
								data: xAxisData
							}],
							series: [{
								data: seriesData
							}]
						});
					}
				}, $template2.back.board.bar.base.interval);
			})
		},
		init(){
			if(this.$storage.get('Token')){
				this.$http({
					url: `${this.$storage.get('sessionTable')}/session`,
					method: "get"
				}).then(({ data }) => {
					if (data && data.code != 0) {
						router.push({ name: 'login' })
					}
				});
			}else{
				router.push({ name: 'login' })
			}
		},
		getyangzhihuanjingCount() {
			this.$http({
				url: `yangzhihuanjing/count`,
				method: "get"
			}).then(({
				data
			}) => {
				if (data && data.code == 0) {
					this.yangzhihuanjingCount = data.data
				}
			})
		},
// 1234 折多
		yangzhihuanjingChat1() {
			this.$nextTick(()=>{

				var yangzhihuanjingChart1 = echarts.init(document.getElementById("yangzhihuanjingChart1"),'macarons');
				this.$http({
					url: `yangzhihuanjing/valueMul/yangzhiquyu?yColumnNameMul=wendu,suanjiandu,rongjieyang,andan,diandaolv,zhuodu`,
					method: "get",
				}).then(({ data }) => {
					if (data && data.code === 0) {
						let res = data.data;
						let xAxis1 = [];
						let yAxis1 = [];
						let pArray1 = []
						for(let i=0;i<res[0].length;i++){
							if(this.boardBase&&i==this.boardBase.lineNum){
								break;
							}
							xAxis1.push(res[0][i].yangzhiquyu);
							yAxis1.push(parseFloat((res[0][i].total)));
							pArray1.push({
								value: parseFloat((res[0][i].total)),
								name: res[0][i].yangzhiquyu
							})
						}
						let xAxis2 = [];
						let yAxis2 = [];
						let pArray2 = []
						for(let i=0;i<res[1].length;i++){
							if(this.boardBase&&i==this.boardBase.lineNum){
								break;
							}
							xAxis2.push(res[1][i].yangzhiquyu);
							yAxis2.push(parseFloat((res[1][i].total)));
							pArray2.push({
								value: parseFloat((res[1][i].total)),
								name: res[1][i].yangzhiquyu
							})
						}
						let xAxis3 = [];
						let yAxis3 = [];
						let pArray3 = []
						for(let i=0;i<res[2].length;i++){
							if(this.boardBase&&i==this.boardBase.lineNum){
								break;
							}
							xAxis3.push(res[2][i].yangzhiquyu);
							yAxis3.push(parseFloat((res[2][i].total)));
							pArray3.push({
								value: parseFloat((res[2][i].total)),
								name: res[2][i].yangzhiquyu
							})
						}
						let xAxis4 = [];
						let yAxis4 = [];
						let pArray4 = []
						for(let i=0;i<res[3].length;i++){
							if(this.boardBase&&i==this.boardBase.lineNum){
								break;
							}
							xAxis4.push(res[3][i].yangzhiquyu);
							yAxis4.push(parseFloat((res[3][i].total)));
							pArray4.push({
								value: parseFloat((res[3][i].total)),
								name: res[3][i].yangzhiquyu
							})
						}
						let xAxis5 = [];
						let yAxis5 = [];
						let pArray5 = []
						for(let i=0;i<res[4].length;i++){
							if(this.boardBase&&i==this.boardBase.lineNum){
								break;
							}
							xAxis5.push(res[4][i].yangzhiquyu);
							yAxis5.push(parseFloat((res[4][i].total)));
							pArray5.push({
								value: parseFloat((res[4][i].total)),
								name: res[4][i].yangzhiquyu
							})
						}
						let xAxis6 = [];
						let yAxis6 = [];
						let pArray6 = []
						for(let i=0;i<res[5].length;i++){
							if(this.boardBase&&i==this.boardBase.lineNum){
								break;
							}
							xAxis6.push(res[5][i].yangzhiquyu);
							yAxis6.push(parseFloat((res[5][i].total)));
							pArray6.push({
								value: parseFloat((res[5][i].total)),
								name: res[5][i].yangzhiquyu
							})
						}
						var option = {};
						let titleObj = this.line.title
						titleObj.text = '环境数据分析'
						
						const legendObj = this.line.legend
						legendObj.data = [
							'温度'.split('/').length>1?'温度'.split('/')[0]:'温度',
							'pH值'.split('/').length>1?'pH值'.split('/')[0]:'pH值',
							'溶解氧'.split('/').length>1?'溶解氧'.split('/')[0]:'溶解氧',
							'氨氮'.split('/').length>1?'氨氮'.split('/')[0]:'氨氮',
							'电导率'.split('/').length>1?'电导率'.split('/')[0]:'电导率',
							'浊度'.split('/').length>1?'浊度'.split('/')[0]:'浊度',
						]
				
						let xAxisObj = this.line.xAxis
						xAxisObj.type = 'category'
						xAxisObj.data = xAxis1
						
						let yAxisObj = this.line.yAxis
						yAxisObj.type = 'value'
						
						let seriesObj = [
							{
								data: yAxis1,
								type: '温度'.split('/').length>1?'温度'.split('/')[1]:'line',
								name: '温度'.split('/').length>1?'温度'.split('/')[0]:'温度',
							},
							{
								data: yAxis2,
								type: 'pH值'.split('/').length>1?'pH值'.split('/')[1]:'line',
								name: 'pH值'.split('/').length>1?'pH值'.split('/')[0]:'pH值',
							},
							{
								data: yAxis3,
								type: '溶解氧'.split('/').length>1?'溶解氧'.split('/')[1]:'line',
								name: '溶解氧'.split('/').length>1?'溶解氧'.split('/')[0]:'溶解氧',
							},
							{
								data: yAxis4,
								type: '氨氮'.split('/').length>1?'氨氮'.split('/')[1]:'line',
								name: '氨氮'.split('/').length>1?'氨氮'.split('/')[0]:'氨氮',
							},
							{
								data: yAxis5,
								type: '电导率'.split('/').length>1?'电导率'.split('/')[1]:'line',
								name: '电导率'.split('/').length>1?'电导率'.split('/')[0]:'电导率',
							},
							{
								data: yAxis6,
								type: '浊度'.split('/').length>1?'浊度'.split('/')[1]:'line',
								name: '浊度'.split('/').length>1?'浊度'.split('/')[0]:'浊度',
							},
						]
						for(let i=0;i<seriesObj.length;i++){
							seriesObj[i] = Object.assign(seriesObj[i] , this.line.series)
						}
						const gridObj = this.line.grid
						let tooltipObj = {trigger: 'axis'}
						tooltipObj = Object.assign(tooltipObj , this.line.tooltip?this.line.tooltip:{})
						option = {
							backgroundColor: this.line.backgroundColor,
							color: this.line.color,
							title: titleObj,
							legend: legendObj,
							grid: gridObj,
							tooltip: tooltipObj,
							xAxis: xAxisObj,
							yAxis: yAxisObj,
							series: seriesObj
						};
						// 使用刚指定的配置项和数据显示图表。
						yangzhihuanjingChart1.setOption(option);
				
						//根据窗口的大小变动图表
						window.onresize = function() {
							yangzhihuanjingChart1.resize();
						};
					}else{
						this.$message({
							message: data.msg,
							type: "warning",
							duration: 1500,
						})
					}
				});
			})
		},


		getwupinkucunCount() {
			this.$http({
				url: `wupinkucun/count`,
				method: "get"
			}).then(({
				data
			}) => {
				if (data && data.code == 0) {
					this.wupinkucunCount = data.data
				}
			})
		},
// 1234 竖
		wupinkucunChat1() {
			this.$nextTick(()=>{

				var wupinkucunChart1 = echarts.init(document.getElementById("wupinkucunChart1"),'macarons');
				this.$http({
					url: `wupinkucun/value/wupinmingcheng/shuliang`,
					method: "get",
				}).then(({ data }) => {
					if (data && data.code === 0) {
						let res = data.data;
						let xAxis = [];
						let yAxis = [];
						let pArray = []
						for(let i=0;i<res.length;i++){
							if(this.boardBase&&i==this.boardBase.barNum){
								break;
							}
							xAxis.push(res[i].wupinmingcheng);
							yAxis.push(parseFloat((res[i].total)));
							pArray.push({
								value: parseFloat((res[i].total)),
								name: res[i].wupinmingcheng
							})
						}
						var option = {};
						let titleObj = this.bar.title
						titleObj.text = '物品库存统计'
						
						const legendObj = this.bar.legend
						let tooltipObj = {trigger: 'item',formatter: '{b} : {c}'}
						tooltipObj = Object.assign(tooltipObj , this.bar.tooltip?this.bar.tooltip:{})
				
						let xAxisObj = this.bar.xAxis
						xAxisObj.type = 'category'
						xAxisObj.data = xAxis
						
						let yAxisObj = this.bar.yAxis
						yAxisObj.type = 'value'
						let seriesObj = {
							data: yAxis,
							type: 'bar',
						}
						seriesObj = Object.assign(seriesObj , this.bar.series)
						const gridObj = this.bar.grid
						
						option = {
							backgroundColor: this.bar.backgroundColor,
							color: this.bar.color,
							title: titleObj,
							legend: legendObj,
							grid: gridObj,
							tooltip: tooltipObj,
							xAxis: xAxisObj,
							yAxis: yAxisObj,
							series: [seriesObj]
						};
						// 使用刚指定的配置项和数据显示图表。
						wupinkucunChart1.setOption(option);
				
						//根据窗口的大小变动图表
						window.onresize = function() {
							wupinkucunChart1.resize();
						};
					}else{
						this.$message({
							message: data.msg,
							type: "warning",
							duration: 1500,
						})
					}
				});
			})
		},


		getcaigoujiluCount() {
			this.$http({
				url: `caigoujilu/count`,
				method: "get"
			}).then(({
				data
			}) => {
				if (data && data.code == 0) {
					this.caigoujiluCount = data.data
				}
			})
		},
// 1234 横
		caigoujiluChat1() {
			this.$nextTick(()=>{

				var caigoujiluChart1 = echarts.init(document.getElementById("caigoujiluChart1"),'macarons');
				this.$http({
					url: `caigoujilu/value/wupinmingcheng/shuliang`,
					method: "get",
				}).then(({ data }) => {
					if (data && data.code === 0) {
						let res = data.data;
						let xAxis = [];
						let yAxis = [];
						let pArray = []
						for(let i=0;i<res.length;i++){
							if(this.boardBase&&i==this.boardBase.barNum){
								break;
							}
							xAxis.push(res[i].wupinmingcheng);
							yAxis.push(parseFloat((res[i].total)));
							pArray.push({
								value: parseFloat((res[i].total)),
								name: res[i].wupinmingcheng
							})
						}
						var option = {};
						let titleObj = this.bar.title
						titleObj.text = '采购量统计'
						
						const legendObj = this.bar.legend
						let tooltipObj = {trigger: 'item',formatter: '{b} : {c}'}
						tooltipObj = Object.assign(tooltipObj , this.bar.tooltip?this.bar.tooltip:{})
				
						let xAxisObj = this.bar.xAxis
						xAxisObj.type = 'value'
						
						let yAxisObj = this.bar.yAxis
						yAxisObj.type = 'category'
						yAxisObj.data = xAxis
						let seriesObj = {
							data: yAxis,
							type: 'bar',
						}
						seriesObj = Object.assign(seriesObj , this.bar.series)
						const gridObj = this.bar.grid
						
						option = {
							backgroundColor: this.bar.backgroundColor,
							color: this.bar.color,
							title: titleObj,
							legend: legendObj,
							grid: gridObj,
							tooltip: tooltipObj,
							xAxis: xAxisObj,
							yAxis: yAxisObj,
							series: [seriesObj]
						};
						// 使用刚指定的配置项和数据显示图表。
						caigoujiluChart1.setOption(option);
				
						//根据窗口的大小变动图表
						window.onresize = function() {
							caigoujiluChart1.resize();
						};
					}else{
						this.$message({
							message: data.msg,
							type: "warning",
							duration: 1500,
						})
					}
				});
			})
		},


		gettouweirizhiCount() {
			this.$http({
				url: `touweirizhi/count`,
				method: "get"
			}).then(({
				data
			}) => {
				if (data && data.code == 0) {
					this.touweirizhiCount = data.data
				}
			})
		},
// 1234 折
		touweirizhiChat1() {
			this.$nextTick(()=>{

				var touweirizhiChart1 = echarts.init(document.getElementById("touweirizhiChart1"),'macarons');
				this.$http({
					url: `touweirizhi/value/wupinmingcheng/shuliang`,
					method: "get",
				}).then(({ data }) => {
					if (data && data.code === 0) {
						let res = data.data;
						let xAxis = [];
						let yAxis = [];
						let pArray = []
						for(let i=0;i<res.length;i++){
							if(this.boardBase&&i==this.boardBase.lineNum){
								break;
							}
							xAxis.push(res[i].wupinmingcheng);
							yAxis.push(parseFloat((res[i].total)));
							pArray.push({
								value: parseFloat((res[i].total)),
								name: res[i].wupinmingcheng
							})
						}
						var option = {};
						let titleObj = this.line.title
						titleObj.text = '投喂量统计'
						
						const legendObj = this.line.legend
						let tooltipObj = { trigger: 'item',formatter: '{b} : {c}'}
						tooltipObj = Object.assign(tooltipObj , this.line.tooltip?this.line.tooltip:{})
						let xAxisObj = this.line.xAxis
						xAxisObj.type = 'category'
						xAxisObj.data = xAxis
						
						let yAxisObj = this.line.yAxis
						yAxisObj.type = 'value'
						const gridObj = this.line.grid
						
						let seriesObj = {
							data: yAxis,
							type: 'line',
						}
						seriesObj = Object.assign(seriesObj , this.line.series)
						option = {
							backgroundColor: this.line.backgroundColor,
							color: this.line.color,
							title: titleObj,
							legend: legendObj,
							grid: gridObj,
							tooltip: tooltipObj,
							xAxis: xAxisObj,
							yAxis: yAxisObj,
							series: [seriesObj]
						};
						// 使用刚指定的配置项和数据显示图表。
						touweirizhiChart1.setOption(option);
				
						//根据窗口的大小变动图表
						window.onresize = function() {
							touweirizhiChart1.resize();
						};
					}else{
						this.$message({
							message: data.msg,
							type: "warning",
							duration: 1500,
						})
					}
				});
			})
		},


		getshebeixinxiCount() {
			this.$http({
				url: `shebeixinxi/count`,
				method: "get"
			}).then(({
				data
			}) => {
				if (data && data.code == 0) {
					this.shebeixinxiCount = data.data
				}
			})
		},
// 1234 饼
		shebeixinxiChat1() {
			this.$nextTick(()=>{

				var shebeixinxiChart1 = echarts.init(document.getElementById("shebeixinxiChart1"),'macarons');
				this.$http({
					url: `shebeixinxi/value/shebeimingcheng/shuliang`,
					method: "get",
				}).then(({ data }) => {
					if (data && data.code === 0) {
						let res = data.data;
						let xAxis = [];
						let yAxis = [];
						let pArray = []
						for(let i=0;i<res.length;i++){
							if(this.boardBase&&i==this.boardBase.pieNum){
								break;
							}
							xAxis.push(res[i].shebeimingcheng);
							yAxis.push(parseFloat((res[i].total)));
							pArray.push({
								value: parseFloat((res[i].total)),
								name: res[i].shebeimingcheng
							})
						}
						var option = {};
						let titleObj = this.pie.title
						titleObj.text = '设备库存统计'
						
						const legendObj = this.pie.legend
						let tooltipObj = {trigger: 'item',formatter: '{b} : {c} ({d}%)'}
						tooltipObj = Object.assign(tooltipObj , this.pie.tooltip?this.pie.tooltip:{})
						
						let seriesObj = {
							type: 'pie',
							radius: '55%',
							center: ['50%', '60%'],
							data: pArray,
							emphasis: {
								itemStyle: {
									shadowBlur: 10,
									shadowOffsetX: 0,
									shadowColor: 'rgba(0, 0, 0, 0.5)'
								}
							}
						}
						seriesObj = Object.assign(seriesObj , this.pie.series)
						const gridObj = this.pie.grid
						option = {
							backgroundColor: this.pie.backgroundColor,
							color: this.pie.color,
							title: titleObj,
							legend: legendObj,
							grid: gridObj,
							tooltip: tooltipObj,
							series: [seriesObj]
						};
						// 使用刚指定的配置项和数据显示图表。
						shebeixinxiChart1.setOption(option);
				
						//根据窗口的大小变动图表
						window.onresize = function() {
							shebeixinxiChart1.resize();
						};
					}else{
						this.$message({
							message: data.msg,
							type: "warning",
							duration: 1500,
						})
					}
				});
			})
		},


	}
};
</script>
<style lang="scss" scoped>
	.home-content {
		padding: 10px 30px;
		align-content: flex-start;
		background: url(http://codegen.caihongy.cn/20250121/c223644b7e754470a6dcee6f1720f894.png) no-repeat center top / cover;
		display: flex;
		width: 100%;
		min-height: 100vh;
		justify-content: flex-start;
		align-items: flex-start;
		flex-wrap: wrap;
		.home-title {
			border-radius: 5px;
			padding: 10px 0;
			box-shadow: 0 0px 0px rgba(0,0,0,.3);
			margin: 10px 0;
			display: flex;
			width: 100%;
			justify-content: center;
			align-items: center;
			transition: 0.3s;
			.titles {
				padding: 0;
				color: #333;
				font-weight: 600;
				font-size: 30px;
				line-height: 44px;
				span {
				}
			}
		}
		.home-title:hover {
			transform: translate3d(0, 0px, 0);
			z-index: 1;
			background: rgba(255,255,255,0);
		}
		.statis-box {
			border-radius: 10px;
			padding: 0;
			margin: 10px auto 0;
			background: none;
			display: flex;
			width: calc(100% - 0px);
			justify-content: center;
			align-items: center;
			.statis1 {
				border: 0px solid #ccc;
				border-radius: 2px;
				padding: 20px 10px;
				margin: 0 10px 10px;
				background: url(http://codegen.caihongy.cn/20240918/d27c5ffea9684e42ba6cf8ff01d595dc.png) center center/100% 100%;
				display: flex;
				width: calc(20% - 20px);
				transition: 0.3s;
				.left {
					border-radius: 100%;
					background: #e9f0f9;
					display: none;
					width: 66px;
					justify-content: center;
					align-items: center;
					height: 66px;
					.iconfont {
						color: #2582f3;
						font-size: 40px;
					}
				}
				.right {
					flex-direction: column;
					display: flex;
					width: 100%;
					justify-content: center;
					align-items: center;
					.num {
						margin: 5px 0;
						color: #333;
						font-weight: bold;
						font-size: 30px;
						line-height: 24px;
						height: 24px;
					}
					.name {
						margin: 5px 0;
						color: #666;
						font-size: 15px;
						line-height: 24px;
						height: 24px;
						order: -1;
					}
				}
			}
			.statis1:hover {
				transform: translate3d(0, -10px, 0);
				z-index: 1;
				background: url(http://codegen.caihongy.cn/20240918/d27c5ffea9684e42ba6cf8ff01d595dc.png) center center/100% 100%;
			}
			.statis2 {
				border: 0px solid #ccc;
				border-radius: 2px;
				padding: 20px 10px;
				margin: 0 10px 10px;
				background: url(http://codegen.caihongy.cn/20240918/d27c5ffea9684e42ba6cf8ff01d595dc.png) center center/100% 100%;
				display: flex;
				width: calc(20% - 20px);
				transition: 0.3s;
				.left {
					border-radius: 100%;
					background: #fcece1;
					display: none;
					width: 60px;
					justify-content: center;
					align-items: center;
					height: 60px;
					.iconfont {
						color: #f56c17;
						font-size: 40px;
					}
				}
				.right {
					flex-direction: column;
					display: flex;
					width: 100%;
					justify-content: center;
					align-items: center;
					.num {
						margin: 5px 0;
						color: #333;
						font-weight: bold;
						font-size: 30px;
						line-height: 24px;
						height: 24px;
					}
					.name {
						margin: 5px 0;
						color: #666;
						font-size: 15px;
						line-height: 24px;
						height: 24px;
						order: -1;
					}
				}
			}
			.statis2:hover {
				transform: translate3d(0, -10px, 0);
				z-index: 1;
				background: url(http://codegen.caihongy.cn/20240918/d27c5ffea9684e42ba6cf8ff01d595dc.png) center center/100% 100%;
			}
			.statis3 {
				border: 0px solid #ccc;
				border-radius: 2px;
				padding: 20px 10px;
				margin: 0 10px 10px;
				background: url(http://codegen.caihongy.cn/20240918/d27c5ffea9684e42ba6cf8ff01d595dc.png) center center/100% 100%;
				display: flex;
				width: calc(20% - 20px);
				transition: 0.3s;
				.left {
					border-radius: 100%;
					background: #e7fbfd;
					display: none;
					width: 60px;
					justify-content: center;
					align-items: center;
					height: 60px;
					.iconfont {
						color: #21c2f6;
						font-size: 40px;
					}
				}
				.right {
					flex-direction: column;
					display: flex;
					width: 100%;
					justify-content: center;
					align-items: center;
					.num {
						margin: 5px 0;
						color: #333;
						font-weight: bold;
						font-size: 30px;
						line-height: 24px;
						height: 24px;
					}
					.name {
						margin: 5px 0;
						color: #666;
						font-size: 15px;
						line-height: 24px;
						height: 24px;
						order: -1;
					}
				}
			}
			.statis3:hover {
				transform: translate3d(0, -10px, 0);
				z-index: 1;
				background: url(http://codegen.caihongy.cn/20240918/d27c5ffea9684e42ba6cf8ff01d595dc.png) center center/100% 100%;
			}
			.statis4 {
				border: 0px solid #ccc;
				border-radius: 2px;
				padding: 20px 10px;
				margin: 0 10px 10px;
				background: url(http://codegen.caihongy.cn/20240918/d27c5ffea9684e42ba6cf8ff01d595dc.png) center center/100% 100%;
				display: flex;
				width: calc(20% - 20px);
				transition: 0.3s;
				.left {
					border-radius: 100%;
					background: #e0ffe9;
					display: none;
					width: 60px;
					justify-content: center;
					align-items: center;
					height: 60px;
					.iconfont {
						color: #45d45a;
						font-size: 40px;
					}
				}
				.right {
					flex-direction: column;
					display: flex;
					width: 100%;
					justify-content: center;
					align-items: center;
					.num {
						margin: 5px 0;
						color: #333;
						font-weight: bold;
						font-size: 30px;
						line-height: 24px;
						height: 24px;
					}
					.name {
						margin: 5px 0;
						color: #666;
						font-size: 15px;
						line-height: 24px;
						height: 24px;
						order: -1;
					}
				}
			}
			.statis4:hover {
				transform: translate3d(0, -10px, 0);
				z-index: 1;
				background: url(http://codegen.caihongy.cn/20240918/d27c5ffea9684e42ba6cf8ff01d595dc.png) center center/100% 100%;
			}
			.statis5 {
				border: 0px solid #ccc;
				border-radius: 2px;
				padding: 20px 10px;
				margin: 0 10px 10px;
				background: url(http://codegen.caihongy.cn/20240918/d27c5ffea9684e42ba6cf8ff01d595dc.png) center center/100% 100%;
				display: flex;
				width: calc(20% - 20px);
				transition: 0.3s;
				.left {
					border-radius: 100%;
					background: #fbe8db;
					display: none;
					width: 60px;
					justify-content: center;
					align-items: center;
					height: 60px;
					.iconfont {
						color: #d26515;
						font-size: 40px;
					}
				}
				.right {
					flex-direction: column;
					display: flex;
					width: 100%;
					justify-content: center;
					align-items: center;
					.num {
						margin: 5px 0;
						color: #333;
						font-weight: bold;
						font-size: 30px;
						line-height: 24px;
						height: 24px;
					}
					.name {
						margin: 5px 0;
						color: #666;
						font-size: 15px;
						line-height: 24px;
						height: 24px;
						order: -1;
					}
				}
			}
			.statis5:hover {
				transform: translate3d(0, -10px, 0);
				z-index: 1;
				background: url(http://codegen.caihongy.cn/20240918/d27c5ffea9684e42ba6cf8ff01d595dc.png) center center/100% 100%;
			}
		}
		// echarts5
		.type5 {
			padding: 0;
			margin: 0;
			align-content: flex-start;
			background: none;
			flex: 2;
			display: flex;
			width: 68%;
			justify-content: space-between;
			flex-wrap: wrap;
			height: auto;
			.echarts1 {
				border: 0px solid #ccc;
				border-radius: 10px;
				padding: 20px;
				margin: 10px;
				background: #EFFBFF;
				width: 100%;
				transition: 0.3s;
				height: 420px;
			}
			.echarts1:hover {
				transform: translate3d(0, -10px, 0);
				z-index: 1;
				background: #EFFBFF;
			}
			.echarts2 {
				border: 0px solid #ccc;
				border-radius: 10px;
				padding: 20px;
				margin: 10px;
				background: #EFFBFF;
				width: calc(50% - 20px);
				transition: 0.3s;
				height: 420px;
			}
			.echarts2:hover {
				transform: translate3d(0, -10px, 0);
				z-index: 1;
				background: #EFFBFF;
			}
			.echarts3 {
				border: 0px solid #ccc;
				border-radius: 10px;
				padding: 20px;
				margin: 10px;
				background: #EFFBFF;
				width: calc(50% - 20px);
				transition: 0.3s;
				height: 420px;
			}
			.echarts3:hover {
				transform: translate3d(0, -10px, 0);
				z-index: 1;
				background: #EFFBFF;
			}
			.echarts4 {
				border: 0px solid #ccc;
				border-radius: 10px;
				padding: 20px;
				margin: 10px;
				background: #EFFBFF;
				width: calc(50% - 20px);
				transition: 0.3s;
				height: 420px;
			}
			.echarts4:hover {
				transform: translate3d(0, -10px, 0);
				z-index: 1;
				background: #EFFBFF;
			}
			.echarts5 {
				border: 0px solid #ccc;
				border-radius: 10px;
				padding: 20px;
				margin: 10px;
				background: #EFFBFF;
				width: calc(50% - 20px);
				transition: 0.3s;
				height: 420px;
			}
			.echarts5:hover {
				transform: translate3d(0, -10px, 0);
				z-index: 1;
				background: #EFFBFF;
			}
		}
	}
	
	.echarts-flag-2 {
		display: flex;
		flex-wrap: wrap;
		justify-content: space-between;
		padding: 10px 20px;
		background: rebeccapurple;
	
		&>div {
			width: 32%;
			height: 300px;
			margin: 10px 0;
			background: rgba(255,255,255,.1);
			border-radius: 8px;
			padding: 10px 20px;
		}
	}
	.animate__animated {
		animation-fill-mode: none;
	}
</style>
