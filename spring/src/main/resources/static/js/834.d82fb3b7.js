"use strict";(self["webpackChunkvue"]=self["webpackChunkvue"]||[]).push([[834],{5834:function(t,e,a){a.r(e),a.d(e,{default:function(){return c}});var n=function(){var t=this,e=t._self._c;return e("center",[e("div",[e("h1",[t._v("多维度分析:随机抽样")]),e("div",{attrs:{id:"random"}})])])},i=[],o=(a(7658),a(70)),s=a(3139),r=a(9286),l={name:"D_Random",components:{ParticlesBg:r.r},data(){return{name:[],value:[]}},mounted(){o.ZP.get("http://localhost:8000/random").then((t=>{const e=t.data,a=[],n=[];for(let i=0;i<e.length;i++)a.push(e[i]["tag_name"]),n.push(e[i]["total_count"]);this.name=a,this.value=n,this.Random()}))},methods:{Random(){const t=s.init(document.getElementById("random")),e={tooltip:{trigger:"axis",axisPointer:{type:"shadow"}},grid:{left:"3%",right:"4%",bottom:"3%",containLabel:!0},xAxis:[{show:!0,type:"category",data:this.name,axisTick:{alignWithLabel:!0},axisLabel:{interval:0}}],yAxis:[{type:"value"}],axisLabel:{interval:0},series:[{name:"Language",type:"bar",barWidth:"60%",data:this.value,itemStyle:{color:"rgba(255,128,190,0.3)"}}]};t.setOption(e)}}},u=l,d=a(1001),h=(0,d.Z)(u,n,i,!1,null,"e90133ae",null),c=h.exports}}]);
//# sourceMappingURL=834.d82fb3b7.js.map