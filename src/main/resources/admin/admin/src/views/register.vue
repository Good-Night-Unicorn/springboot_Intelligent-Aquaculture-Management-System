<template>
	<div>
		<div class="register-container">
			<el-form v-if="pageFlag=='register'" ref="ruleForm" class="rgs-form animate__animated animate__slideInDown" :model="ruleForm" :rules="rules">
				<div class="rgs-form2">
					<div class="title">基于springboot+vue智能水产养殖管理系统注册</div>
					<el-form-item class="list-item" v-if="tableName=='yonghu'">
						<div class="lable" :class="changeRules('yonghuzhanghao')?'required':''">用户账号：</div>
						<el-input  v-model="ruleForm.yonghuzhanghao"  autocomplete="off" placeholder="用户账号"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='yonghu'">
						<div class="lable" :class="changeRules('mima')?'required':''">密码：</div>
						<el-input  v-model="ruleForm.mima"  autocomplete="off" placeholder="密码"  type="password"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='yonghu'">
						<div class="lable" :class="changeRules('mima')?'required':''">确认密码：</div>
						<el-input  v-model="ruleForm.mima2" autocomplete="off" placeholder="确认密码" type="password" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='yonghu'">
						<div class="lable" :class="changeRules('yonghuxingming')?'required':''">用户姓名：</div>
						<el-input  v-model="ruleForm.yonghuxingming"  autocomplete="off" placeholder="用户姓名"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='yonghu'">
						<div class="lable" :class="changeRules('xingbie')?'required':''">性别：</div>
						<el-select v-model="ruleForm.xingbie" placeholder="请选择性别" >
							<el-option
								v-for="(item,index) in yonghuxingbieOptions"
								v-bind:key="index"
								:label="item"
								:value="item">
							</el-option>
						</el-select>
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='yonghu'">
						<div class="lable" :class="changeRules('shouji')?'required':''">手机：</div>
						<el-input  v-model="ruleForm.shouji"  autocomplete="off" placeholder="手机"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='yonghu'">
						<div class="lable" :class="changeRules('touxiang')?'required':''">头像：</div>
						<file-upload
							tip="点击上传头像"
							action="file/upload"
							:limit="3"
							:multiple="true"
							:fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
							@change="yonghutouxiangUploadChange"
						></file-upload>
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='yonghu'">
						<div class="lable" :class="changeRules('pquestion')?'required':''">密保问题：</div>
						<el-input  v-model="ruleForm.pquestion"  autocomplete="off" placeholder="密保问题"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='yonghu'">
						<div class="lable" :class="changeRules('panswer')?'required':''">密保答案：</div>
						<el-input  v-model="ruleForm.panswer"  autocomplete="off" placeholder="密保答案"  type="text"  />
					</el-form-item>
					<div class="register-btn">
						<div class="register-btn1">
							<button type="button" class="r-btn" @click="login()">注册</button>
						</div>
						<div class="register-btn2">
							<div class="r-login" @click="close()">已有账号，直接登录</div>
						</div>
					</div>
				</div>
			</el-form>
		</div>
	</div>
</template>

<script>
	import 'animate.css'
export default {
	data() {
		return {
			ruleForm: {
			},
			forgetForm: {},
            pageFlag : '',
			tableName:"",
			rules: {},
            yonghuxingbieOptions: [],
		};
	},
	mounted(){
		this.pageFlag = this.$route.query.pageFlag
		if(this.$route.query.pageFlag=='register'){
			
			let table = this.$storage.get("loginTable");
			this.tableName = table;
			if(this.tableName=='yonghu'){
				this.ruleForm = {
					yonghuzhanghao: '',
					mima: '',
					yonghuxingming: '',
					xingbie: '',
					shouji: '',
					touxiang: '',
					pquestion: '',
					panswer: '',
					status: '',
				}
			}
			if ('yonghu' == this.tableName) {
				this.rules.yonghuzhanghao = [{ required: true, message: '请输入用户账号', trigger: 'blur' }]
			}
			if ('yonghu' == this.tableName) {
				this.rules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }]
			}
			if ('yonghu' == this.tableName) {
				this.rules.yonghuxingming = [{ required: true, message: '请输入用户姓名', trigger: 'blur' }]
			}
			if ('yonghu' == this.tableName) {
				this.rules.xingbie = [{ required: true, message: '请输入性别', trigger: 'blur' }]
			}
			if ('yonghu' == this.tableName) {
				this.rules.shouji = [{ required: true, message: '请输入手机', trigger: 'blur' }]
			}
			this.yonghuxingbieOptions = "男,女".split(',')
		}
	},
	created() {
	},
	destroyed() {
		  	},
	methods: {
		changeRules(name){
			if(this.rules[name]){
				return true
			}
			if(name == 'pquestion'||name=='panswer') {
				return true
			}
			return false
		},
		// 获取uuid
		getUUID () {
			return new Date().getTime();
		},
		close(){
			this.$router.push({ path: "/login" });
		},
        yonghutouxiangUploadChange(fileUrls) {
            this.ruleForm.touxiang = fileUrls;
        },

        // 多级联动参数


		// 注册
		login() {
			var url=this.tableName+"/register";
			if((!this.ruleForm.yonghuzhanghao) && `yonghu` == this.tableName){
				this.$message.error(`用户账号不能为空`);
				return
			}
			if((!this.ruleForm.mima) && `yonghu` == this.tableName){
				this.$message.error(`密码不能为空`);
				return
			}
			if((this.ruleForm.mima!=this.ruleForm.mima2) && `yonghu` == this.tableName){
				this.$message.error(`两次密码输入不一致`);
				return
			}
			if((!this.ruleForm.yonghuxingming) && `yonghu` == this.tableName){
				this.$message.error(`用户姓名不能为空`);
				return
			}
			if((!this.ruleForm.xingbie) && `yonghu` == this.tableName){
				this.$message.error(`性别不能为空`);
				return
			}
			if((!this.ruleForm.shouji) && `yonghu` == this.tableName){
				this.$message.error(`手机不能为空`);
				return
			}
			if(`yonghu` == this.tableName && this.ruleForm.shouji &&(!this.$validate.isMobile(this.ruleForm.shouji))){
				this.$message.error(`手机应输入手机格式`);
				return
			}
            if(this.ruleForm.touxiang!=null) {
                this.ruleForm.touxiang = this.ruleForm.touxiang.replace(new RegExp(this.$base.url,"g"),"");
            }
			if(`yonghu` == this.tableName && this.ruleForm.pquestion==''){
				this.$message.error(`密保问题不能为空`);
				return
			}
			if(`yonghu` == this.tableName && this.ruleForm.panswer==''){
				this.$message.error(`密保答案不能为空`);
				return
			}
			this.$http({
				url: url,
				method: "post",
				data:this.ruleForm
			}).then(({ data }) => {
				if (data && data.code === 0) {
					this.$message({
						message: "注册成功",
						type: "success",
						duration: 1500,
						onClose: () => {
							this.$router.replace({ path: "/login" });
						}
					});
				} else {
					this.$message.error(data.msg);
				}
			});
		}
	}
};
</script>

<style lang="scss" scoped>
.register-container {
	position: relative;
	background: url(http://codegen.caihongy.cn/20240911/a4e4455b61ac4c64a256bc94bc6888b4.png);
	background-repeat: no-repeat;
	background-size: cover !important;
	background: url(http://codegen.caihongy.cn/20240911/a4e4455b61ac4c64a256bc94bc6888b4.png);
	display: flex;
	width: 100%;
	min-height: 100vh;
	justify-content: center;
	align-items: center;
	background-position: center center;
	.rgs-form {
		.rgs-form2 {
		border-radius: 20px;
		padding: 20px 40px;
		flex-direction: column;
		background: rgba(255,255,255,0.5);
		display: flex;
		width: 100%;
		align-items: center;
		}
		padding: 0;
		margin: 30px auto 60px;
		z-index: 1000;
		display: flex;
		flex-wrap: wrap;
		border-radius: 20px;
		box-shadow: 10px 10px 10px 0px #42A7FC;
		flex-direction: column;
		background: #42A7FC;
		width: 40%;
		align-items: center;
		position: relative;
		height: auto;
		.title {
			padding: 0 40px;
			margin: 10px 0 20px 0;
			color: #000;
			background: none;
			font-weight: 600;
			width: 100%;
			font-size: 26px;
			line-height: 40px;
			text-align: center;
		}
		.list-item {
			padding: 0 0 0 0px;
			margin: 0 0 10px;
			width: 100%;
			position: relative;
			height: auto;
			/deep/ .el-form-item__content {
				display: flex;
				align-items: flex-start;
			}
			.lable {
				border-radius: 10px 0 0 10px;
				padding: 0 10px;
				box-shadow: 0 2px 4px rgba(0,0,0,.2);
				color: #fff;
				background: #3C9AFF;
				width: 130px;
				font-size: 16px;
				line-height: 60px;
				text-align: right;
			}
			.el-input {
				flex: 1;
				width: 100%;
			}
			.el-input /deep/ .el-input__inner {
				border: 1px solid #efeff7;
				border-radius: 0 10px 10px 0;
				padding: 0 10px;
				box-shadow: 0 2px 4px rgba(0,0,0,.2);
				color: #666;
				flex: 1;
				width: 100%;
				font-size: 16px;
				height: 60px;
			}
			.el-input /deep/ .el-input__inner:focus {
				border: 1px solid #efeff7;
				border-radius: 0 10px 10px 0;
				padding: 0 10px;
				box-shadow: 0 2px 4px rgba(0,0,0,.2);
				color: #666;
				flex: 1;
				width: 100%;
				font-size: 16px;
				height: 60px;
			}
			.el-input-number {
				flex: 1;
				width: 100%;
			}
			.el-input-number /deep/ .el-input__inner {
				text-align: center;
				border: 1px solid #efeff7;
				border-radius: 0 10px 10px 0;
				padding: 0 10px;
				box-shadow: 0 2px 4px rgba(0,0,0,.2);
				color: #666;
				flex: 1;
				width: 100%;
				font-size: 16px;
				height: 60px;
			}
			.el-input-number /deep/ .el-input__inner:focus {
				border: 1px solid #efeff7;
				border-radius: 0 10px 10px 0;
				padding: 0 10px;
				box-shadow: 0 2px 4px rgba(0,0,0,.2);
				color: #666;
				flex: 1;
				width: 100%;
				font-size: 16px;
				height: 60px;
			}
			.el-input-number /deep/ .el-input-number__decrease {
				display: none;
			}
			.el-input-number /deep/ .el-input-number__increase {
				display: none;
			}
			.el-select {
				flex: 1;
				width: 100%;
			}
			.el-select /deep/ .el-input__inner {
				border: 1px solid #efeff7;
				border-radius: 0 10px 10px 0;
				padding: 0 10px;
				box-shadow: 0 2px 4px rgba(0,0,0,.2);
				color: #666;
				flex: 1;
				width: 100%;
				font-size: 16px;
				height: 60px;
			}
			.el-select /deep/ .el-input__inner:focus {
				border: 1px solid #efeff7;
				border-radius: 0 10px 10px 0;
				padding: 0 10px;
				box-shadow: 0 2px 4px rgba(0,0,0,.2);
				color: #666;
				flex: 1;
				width: 100%;
				font-size: 16px;
				height: 60px;
			}
			.el-date-editor {
				flex: 1;
				width: 100%;
			}
			.el-date-editor /deep/ .el-input__inner {
				border: 1px solid #efeff7;
				border-radius: 0 10px 10px 0;
				padding: 0 10px 0 30px;
				box-shadow: 0 2px 4px rgba(0,0,0,.2);
				color: #666;
				flex: 1;
				width: 100%;
				font-size: 16px;
				height: 60px;
			}
			.el-date-editor /deep/ .el-input__inner:focus {
				border: 1px solid #efeff7;
				border-radius: 0 10px 10px 0;
				padding: 0 10px 0 30px;
				box-shadow: 0 2px 4px rgba(0,0,0,.2);
				color: #666;
				flex: 1;
				width: 100%;
				font-size: 16px;
				height: 60px;
			}
			.el-date-editor.el-input {
				width: 100%;
			}
			/deep/ .el-upload--picture-card {
				background: transparent;
				border: 0;
				border-radius: 0;
				width: auto;
				height: auto;
				line-height: initial;
				vertical-align: middle;
			}
			/deep/ .upload .upload-img {
				border: 1px solid #efeff7;
				cursor: pointer;
				border-radius: 0px;
				box-shadow: 0 2px 4px rgba(0,0,0,.2);
				margin: 0 0 0 2px;
				color: #999;
				background: #fff;
				width: 90px;
				font-size: 24px;
				line-height: 90px;
				text-align: center;
				height: 90px;
			}
			/deep/ .el-upload-list .el-upload-list__item {
				border: 1px solid #efeff7;
				cursor: pointer;
				border-radius: 0px;
				box-shadow: 0 2px 4px rgba(0,0,0,.2);
				margin: 0 0 0 2px;
				color: #999;
				background: #fff;
				width: 90px;
				font-size: 24px;
				line-height: 90px;
				text-align: center;
				height: 90px;
			}
			/deep/ .el-upload .el-icon-plus {
				border: 1px solid #efeff7;
				cursor: pointer;
				border-radius: 0px;
				box-shadow: 0 2px 4px rgba(0,0,0,.2);
				margin: 0 0 0 2px;
				color: #999;
				background: #fff;
				width: 90px;
				font-size: 24px;
				line-height: 90px;
				text-align: center;
				height: 90px;
			}
			/deep/ .el-upload__tip {
				margin: 0 0 0 2px;
				color: #006CD0;
				font-size: 15px;
			}
			/deep/ .el-input__inner::placeholder {
				color: #999;
				font-size: 16px;
			}
			.required {
				position: relative;
			}
			.required::after{
				color: red;
				left: 0;
				position: inherit;
				content: "*";
				order: -1;
			}
			.editor {
				background: #fff;
				flex: 1;
				width: 100%;
				height: auto;
			}
			.editor>.avatar-uploader {
				line-height: 0;
				height: 0;
			}
		}
		.list-item.email {
			input {
				border: 1px solid #efeff7;
				border-radius: 0 10px 10px 0;
				padding: 0 10px;
				box-shadow: 0 2px 4px rgba(0,0,0,.2);
				color: #666;
				flex: 1;
				width: 100%;
				font-size: 16px;
				height: 60px;
			}
			input:focus {
				border: 1px solid #efeff7;
				border-radius: 0 10px 10px 0;
				padding: 0 10px;
				box-shadow: 0 2px 4px rgba(0,0,0,.2);
				color: #666;
				flex: 1;
				width: 100%;
				font-size: 16px;
				height: 60px;
			}
			input::placeholder {
				color: #999;
				font-size: 16px;
			}
			button {
				border: 0px solid #efeff7;
				cursor: pointer;
				border-radius: 10px;
				padding: 0;
				box-shadow: 0 2px 4px rgba(0,0,0,.2);
				margin: 0 0 0 10px;
				color: #fff;
				background: linear-gradient( 90deg, #3C9AFF 0%, #5BFFE5 100%);
				width: 150px;
				font-size: 17px;
				height: 60px;
			}
			button:hover {
				opacity: 0.8;
			}
		}
		.register-btn {
			width: 100%;
		}
		.register-btn1 {
			left: 0;
			bottom: -30px;
			display: flex;
			width: 100%;
			justify-content: space-around;
			position: absolute;
		}
		.register-btn2 {
			width: 100%;
		}
		.r-btn {
			border: 0px solid rgba(0, 0, 0, 1);
			cursor: pointer;
			border-radius: 10px;
			padding: 0 10px;
			margin: 0 0 0;
			color: #fff;
			background: linear-gradient( 90deg, #3C9AFF 0%, #5BFFE5 100%);
			font-weight: 600;
			width: 40%;
			font-size: 36px;
			min-width: 68px;
			height: 60px;
		}
		.r-btn:hover {
			opacity: 1;
		}
		.r-login {
			cursor: pointer;
			padding: 0;
			color: #006CD0;
			display: inline-block;
			text-decoration: none;
			width: 100%;
			font-size: 15px;
			line-height: 40px;
			text-align: right;
		}
		.r-login:hover {
			opacity: 1;
		}
	}
}
	
	::-webkit-scrollbar {
	  display: none;
	}
</style>
