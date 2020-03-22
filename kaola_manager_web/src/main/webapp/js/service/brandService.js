app.service("brandService",function ($http) {

    this.findAll=function () {
        return $http.get("../brand/findAll.do")
    }

    //保存
    this.save=function (entity) {
        return $http.post("../brand/save.do",entity)
    }


    //修改
    this.update=function (entity) {
        return $http.post("../brand/update.do",entity);
    }

    //查询单条
    this.findOne=function (id) {
        return $http.get("../brand/findOne.do?id="+id);
    }


    //删除
    this.dele=function (ids) {
        return $http.get("../brand/del.do?ids="+ids);
    }

    //分页查询
    this.findPage = function (page,rows) {
        return $http.get("../brand/findPage.do?page="+page+"&rows="+rows);
    }

    //查询
    this.search=function (page,rows,entity) {
        return $http.post("../brand/search.do?page="+page+"&rows="+rows,entity)
    }

    //查询品牌列表
    this.selectOptionList=function () {
        return $http.get("../brand/selectOptionList.do");
    }
})

