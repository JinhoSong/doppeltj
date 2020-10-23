function dataSend() {

    var data=$("#input").val();
    var title=$("#title").val();
    var content=$("#content").val();
    var file=$("#file").val();

    var Board={
        title: title,
        content: content
    };

    var titleAndFile={
        title:title,
        file:file
    }
    console.log(Board);
    console.log(titleAndFile);

    var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");

    $.ajax({
        url: "/board/form",
        data: Board,
        type:"POST",
        success: function () {
            $.ajax({
                url: "/fileupload",
                type: "POST",
                enctype: 'multipart/form-data',
                data: {title:title,file:file},
                contentType : false,
                processData : false
            })
        }
    });

}
