"use strict";(self["webpackChunkvue"]=self["webpackChunkvue"]||[]).push([[242],{2242:function(e,t,a){a.r(t),a.d(t,{default:function(){return p}});var o=function(){var e=this,t=e._self._c;return t("center",[t("div",[t("h1",[e._v("指定五项技术比较")]),t("div",{attrs:{id:"compare"}})])])},n=[],r=(a(7658),a(9286)),l=a(70),i=a(3139),s={name:"C_Compare",components:{ParticlesBg:r.r},mounted(){l.ZP.get("http://localhost:8000/compare").then((e=>{const t=e.data,a=[];for(let o=0;o<t.length;o++){const e={name:"",value:0};e.name=t[o]["tag_name"],e.value=t[o]["total_count"],a.push(e)}this.data=a,this.Compare()}))},methods:{Compare(){const e=i.init(document.getElementById("compare")),t={tooltip:{trigger:"item"},legend:{top:"5%",left:"center"},series:[{name:"Language",type:"pie",radius:["40%","70%"],avoidLabelOverlap:!1,itemStyle:{borderRadius:10,borderColor:"#fff",borderWidth:2},label:{show:!1,position:"center"},emphasis:{label:{show:!0,fontSize:"40",fontWeight:"bold"}},labelLine:{show:!1},data:this.data}]};e.setOption(t)}}},u=s,d=a(1001),c=(0,d.Z)(u,o,n,!1,null,null,null),p=c.exports}}]);
//# sourceMappingURL=242.f0c13c9f.js.map