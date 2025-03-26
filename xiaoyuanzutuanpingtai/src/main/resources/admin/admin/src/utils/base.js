const base = {
    get() {
        return {
            url : "http://localhost:8080/xiaoyuanzutuanpingtai/",
            name: "xiaoyuanzutuanpingtai",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/xiaoyuanzutuanpingtai/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "校园组团平台"
        } 
    }
}
export default base
