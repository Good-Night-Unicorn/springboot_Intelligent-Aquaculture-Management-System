const base = {
    get() {
        return {
            url : "http://localhost:8080/springboot1z11jbg7/",
            name: "springboot1z11jbg7",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/springboot1z11jbg7/front/dist/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "基于springboot+vue智能水产养殖管理系统"
        } 
    }
}
export default base
