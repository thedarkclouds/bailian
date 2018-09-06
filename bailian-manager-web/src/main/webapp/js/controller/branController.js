app.controller('brandController',function($scope,$controller,brandService){

    //伪继承 传递scoope  让两个scoope通用
    $controller("baseController",{$scope:$scope})

    //查询品牌列表
    $scope.findAll=function(){
        //引用服务
        brandService.findAll().success(
            function (response) {

                $scope.list=response;
            }
        );
    };





    //分页
    $scope.findPage=function(page,size){
        //引用服务
        brandService.findPage(page,size).success(
            function(response){
                $scope.list=response.rows; //显示当前页数据
                //初始总记录数，是默认的。分页后重新计算，更新默认值
                $scope.paginationConf.totalItems=response.total;//更新总记录数
            }
        );
    };


    //保存
    $scope.save=function(){
        //save 和update 切换

        var object=null;
        if($scope.entity.id!=null){//如果有 ID
            object=brandService.update($scope.entity);
        }else {
            object=brandService.add($scope.entity);
        }
        object.success(
            function(response){
                if(response.success){
                    //重新查询
                    $scope.reloadList();//重新加载
                }else{
                    //错误提示
                    alert(response.message);
                }
            }
        );
    }

    //查询实体
    $scope.findOne=function(id){
        brandService.findOne(id).success(
            function(response){
                //双向绑定
                $scope.entity= response;
            }
        );
    };


    //批量删除
    $scope.dele=function(){
        //获取选中的复选框
        brandService.dele($scope.selectIds).success(
            function(response){
                if(response.success){
                    $scope.reloadList();//刷新列表
                }
            }
        );
    };

    $scope.searchEntity={};//定义搜索对象
    //条件查询
    $scope.search=function(page,rows){
        brandService.search(page,rows,$scope.searchEntity).success(
            function(response){
                $scope.paginationConf.totalItems=response.total;//更新总记录数
                $scope.list=response.rows;//给列表变量赋值
            }
        );
    }


});
