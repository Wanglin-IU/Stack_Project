"use strict";(self["webpackChunkvue"]=self["webpackChunkvue"]||[]).push([[853],{4853:function(t,e,a){a.r(e),a.d(e,{default:function(){return h}});var n=function(){var t=this,e=t._self._c;return e("center",[e("div",[e("h1",[t._v("提问次数低于30次的技术")]),e("div",{attrs:{id:"lower"}})])])},o=[],i=(a(7658),a(9286)),r=a(3139),s=a(70),l={name:"F_Lower",components:{ParticlesBg:i.r},data(){return{tag_name:[],tag_count:[]}},mounted(){s.ZP.get("http://localhost:8000/lower").then((t=>{const e=t.data,a=[],n=[];for(let o=0;o<e.length;o++)a.push(e[o]["tag_name"]),n.push(e[o]["tag_count"]);this.tag_name=a,this.tag_count=n,this.Lower()}))},methods:{Lower(){const t=r.init(document.getElementById("lower")),e={title:{text:"Technology"},tooltip:{trigger:"axis"},grid:{left:"3%",right:"4%",bottom:"3%",containLabel:!0},xAxis:{type:"category",boundaryGap:!1,data:this.tag_name,axisLabel:{interval:0}},yAxis:{type:"value"},series:[{name:"Language",type:"line",stack:"Total",data:this.tag_count}]};t.setOption(e)}}},u=l,c=a(1001),g=(0,c.Z)(u,n,o,!1,null,"d960472e",null),h=g.exports}}]);
//# sourceMappingURL=853.ae0805aa.js.map