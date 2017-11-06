/**
 * Created by Administrator on 2017/5/13 0013.
 */
$(function(){
    var mf_top =$(".m_footer").offset().top;
    var wh = $(window).height();
    console.log("footertop:"+$(".m_footer").offset().top)
    console.log("window:"+$(window).height())
    if(mf_top<=wh-mf_top){
        $(".m_footer").css({"position":"absolute",'left':0,'bottom':0})
    }
})