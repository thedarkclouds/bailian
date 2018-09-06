app.controller('baseController',function ($scope) {



    //重新加载列表 数据
    $scope.reloadList=function(){
        //切换页码
        $scope.search( $scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage);
    };


    //分页控件配置
    $scope.paginationConf = {
        //当前页
        currentPage: 1,
        //初始总数据条数
        totalItems: 10,
        //每页数量
        itemsPerPage: 10,
        //每页显示数量
        perPageOptions: [10, 20, 30, 40, 50],
        //自动触发
        onChange: function(){
            $scope.reloadList();//重新加载
        }
    };


    /*  JS 的关于数组操作的知识
     （1） 数组的 push 方法：向数组中添加元素
      （2） 数组的 splice 方法：从数组的指定位置移除指定个数的元素 ，参数 1 为位置 ，参数
      2 位移除的个数
     （3）复选框的 checked 属性：用于判断是否被选中*/
    $scope.selectIds=[];//选中的 ID 集合
    //更新复选
    $scope.updateSelection = function($event, id) {
        if($event.target.checked){//如果是被选中,则增加到数组
            $scope.selectIds.push(id);
        }else{
            var index = $scope.selectIds.indexOf(id);
            //移除的位置和个数
            $scope.selectIds.splice(index, 1);//删除
        };
    };

});