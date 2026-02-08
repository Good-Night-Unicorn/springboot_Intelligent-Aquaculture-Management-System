<template>
	<div>
		<div class="login-container">
			<el-form class="login_form animate__animated animate__slideInDown">
				<div class="login_form2">
					<div class="title-container">基于springboot+vue智能水产养殖管理系统登录</div>
					<div v-if="loginType==1" class="list-item">
						<div class="lable">
							账号
						</div>
						<input placeholder="请输入账号" name="username" type="text" v-model="rulesForm.username">
					</div>
					<div v-if="loginType==1" class="list-item">
						<div class="lable">
							密码
						</div>
						<div class="password-box">
							<input placeholder="请输入密码" name="password" :type="showPassword?'text':'password'" v-model="rulesForm.password">
							<span class="icon iconfont" :class="showPassword?'icon-liulan13':'icon-liulan17'" @click="showPassword=!showPassword"></span>
						</div>
					</div>

					<div class="list-item " v-if="roles.length>1">
						<div class="lable">
							
						</div>
						<div prop="loginInRole" class="list-type">
							<el-radio v-if="loginType==1||(loginType==2&&item.roleName!='管理员')" v-for="item in roles" v-bind:key="item.roleName" v-model="rulesForm.role" :label="item.roleName">{{item.roleName}}</el-radio>
						</div>
					</div>

		
					<div class="login-btn">
						<div class="login-btn1">
							<el-button v-if="loginType==1" type="primary" @click="login()" class="loginInBt">登 录</el-button>
						</div>
						<div class="login-btn2">
						</div>
						<div class="login-btn3">
						</div>
					</div>
				</div>
			</el-form>
		</div>
	</div>
</template>
<script>
	import 'animate.css'
	import menu from "@/utils/menu";
	export default {
		data() {
			return {
				verifyCheck2: false,
				flag: false,
				baseUrl:this.$base.url,
				loginType: 1,
				rulesForm: {
					username: "",
					password: "",
					role: "",
				},
				menus: [],
				roles: [],
				tableName: "",
				showPassword: false,
			};
		},
		mounted() {
			let menus = menu.list();
			this.menus = menus;

			for (let i = 0; i < this.menus.length; i++) {
				if (this.menus[i].hasBackLogin=='是') {
					this.roles.push(this.menus[i])
				}
			}

		},
		created() {

		},
		destroyed() {
		},
		components: {
		},
		methods: {

			//注册
			register(tableName){
				this.$storage.set("loginTable", tableName);
				this.$router.push({path:'/register',query:{pageFlag:'register'}})
			},
			// 登陆
			login() {

				if (!this.rulesForm.username) {
					this.$message.error("请输入用户名");
					return;
				}
				if (!this.rulesForm.password) {
					this.$message.error("请输入密码");
					return;
				}
				if(this.roles.length>1) {
					if (!this.rulesForm.role) {
						this.$message.error("请选择角色");
						return;
					}

					let menus = this.menus;
					for (let i = 0; i < menus.length; i++) {
						if (menus[i].roleName == this.rulesForm.role) {
							this.tableName = menus[i].tableName;
						}
					}
				} else {
					this.tableName = this.roles[0].tableName;
					this.rulesForm.role = this.roles[0].roleName;
				}
		
				this.loginPost()
			},
			loginPost() {
				this.$http({
					url: `${this.tableName}/login?username=${this.rulesForm.username}&password=${this.rulesForm.password}`,
					method: "post"
				}).then(({ data }) => {
					if (data && data.code === 0) {
						this.$storage.set("Token", data.token);
						this.$storage.set("role", this.rulesForm.role);
						this.$storage.set("sessionTable", this.tableName);
						this.$storage.set("adminName", this.rulesForm.username);
						this.$nextTick(()=>{
							this.$http({
								url: this.tableName + '/session',
								method: "get"
							}).then(({
								data
							}) => {
								if (data && data.code === 0) {
									if(this.tableName == 'yonghu') {
										this.$storage.set('headportrait',data.data.touxiang)
									}
									if(this.tableName == 'users') {
										this.$storage.set('headportrait',data.data.image)
									}
									this.$storage.set('userForm',JSON.stringify(data.data))
									this.$storage.set('userid',data.data.id);
								} else {
									let message = this.$message
									message.error(data.msg);
								}
								this.$router.replace({ path: "/" });
							});
						})
					} else {
						this.$message.error(data.msg);
					}
				});
			},
		}
	}
</script>

<style lang="scss" scoped>
.login-container {
	min-height: 100vh;
	position: relative;
	background-repeat: no-repeat;
	background-position: center center;
	background-size: cover;
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

	.login_form {
		padding: 0;
		margin: 0;
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
		.login_form2 {
			border-radius: 20px;
			padding: 40px 0px;
			flex-direction: column;
			background: rgba(255,255,255,0.5);
			display: flex;
			width: 100%;
			align-items: center;
		}
		.title-container {
			padding: 0 40px;
			margin: 10px 0 40px 0;
			color: #000;
			background: none;
			font-weight: 600;
			width: 100%;
			font-size: 26px;
			line-height: 40px;
			text-align: center;
		}
		.list-item {
			border-radius: 10px;
			padding: 0;
			box-shadow: 0;
			margin: 0 0 40px;
			display: flex;
			width: 80%;
			align-items: center;
			position: relative;
			.lable {
				border-radius: 10px 0 0 10px;
				padding: 0 10px;
				box-shadow: 0 2px 4px rgba(0,0,0,.2);
				color: #fff;
				background: #3C9AFF;
				width: 100px;
				font-size: 16px;
				line-height: 60px;
				text-align: right;
				min-width: 60px;
			}
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
				outline: none;
				color: #666;
				flex: 1;
				width: 100%;
				font-size: 16px;
				height: 60px;
			}
			.password-box {
				border-radius: 0 10px 10px 0;
				box-shadow: 0 2px 4px rgba(0,0,0,.2);
				flex: 1;
				display: flex;
				width: 100%;
				align-items: center;
				position: relative;
				input {
					border: 1px solid #efeff7;
					border-radius: 0 10px 10px 0;
					padding: 0 10px;
					color: #666;
					width: 100%;
					font-size: 14px;
					height: 60px;
				}
				input:focus {
					border: 1px solid #efeff7;
					border-radius: 0 10px 10px 0;
					padding: 0 10px;
					outline: none;
					color: #666;
					width: 100%;
					font-size: 14px;
					height: 60px;
				}
				.iconfont {
					cursor: pointer;
					z-index: 1;
					color: #000;
					top: 0;
					font-size: 16px;
					line-height: 60px;
					position: absolute;
					right: 10px;
				}
			}
			input::placeholder {
				color: #999;
				font-size: 16px;
			}
		}
		.list-type {
			padding: 0;
			margin: 40px 0 0;
			background: none;
			display: flex;
			width: calc(80% - 0px);
			line-height: 40px;
			flex-wrap: wrap;
			height: auto;
			/deep/ .el-radio__input .el-radio__inner {
				border-radius: 0;
				background: rgba(53, 53, 53, 0);
				border-color: #666;
			}
			/deep/ .el-radio__input.is-checked .el-radio__inner {
				border-radius: 0;
				background: #0674FC;
				border-color: #0674FC;
			}
			/deep/ .el-radio__label {
				color: #666;
				font-size: 16px;
			}
			/deep/ .el-radio__input.is-checked+.el-radio__label {
				color: #0674FC;
				font-size: 16px;
			}
		}
		.login-btn {
			margin: 20px auto;
			display: flex;
			width: 80%;
			justify-content: center;
			align-items: center;
			.login-btn1 {
				left: 0;
				bottom: -30px;
				display: flex;
				width: 100%;
				justify-content: space-around;
				position: absolute;
			}
			.login-btn2 {
				padding: 0;
				display: flex;
				width: 100%;
				justify-content: flex-start;
				align-items: center;
				flex-wrap: wrap;
			}
			.login-btn3 {
				padding: 0;
				width: 100%;
			}
			.loginInBt {
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
			.loginInBt:hover {
				opacity: 1;
			}
			.register {
				border: 0px solid rgba(0, 0, 0, 1);
				cursor: pointer;
				border-radius: 4px;
				padding: 0 10px;
				margin: 0 0 10px;
				color: #006CD0;
				background: none;
				width: auto;
				font-size: 16px;
				height: 34px;
			}
			.register:hover {
				opacity: 0.8;
			}
			.forget {
				border: 0;
				cursor: pointer;
				border-radius: 0;
				padding: 0;
				margin: 0 10px 10px 0;
				color: #006CD0;
				background: none;
				width: 100%;
				font-size: 15px;
				text-align: right;
				height: 34px;
			}
			.forget:hover {
				color: #0d6efd;
				opacity: 1;
			}
		}
	}
}

</style>
