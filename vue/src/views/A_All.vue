<template>
  <center>
    <div>
      <h1>技术标签</h1>
      <div id="all"></div>
    </div>
  </center>
</template>

<script>
import "echarts-wordcloud/dist/echarts-wordcloud.min"
import {ParticlesBg} from 'particles-bg-vue';
import * as echarts3 from "echarts";
import axios from "axios";


export default {
  name: 'A_All',
  components: {
    // eslint-disable-next-line vue/no-unused-components
    ParticlesBg
  },
  // 钩子函数 先执行接口调用后再执行methods中的方法
  mounted() {
    axios.get("http://localhost:8000/all").then(res => {
      // 读取接口请求成功回传回来的数据
      const All = res.data
      const data = []
      for (let i = 0; i < All.length; i++) {
        const x = {value: 0};
        x.name = All[i]['tag_name']
        x.value = All[i]['total_count']
        data.push(x)
      }
      this.data = data
      this.All()
    })
  },
  methods: {
    All() {
      const MyEcharts = echarts3.init(document.getElementById('all'));
      const option = {
        series: [{
          type: 'wordCloud',
          //maskImage: maskImage,
          sizeRange: [10, 50],
          rotationRange: [0, 0],
          rotationStep: 45,
          gridSize: 10,
          shape: 'circle',
          width: '100%',
          height: '100%',
          color: 'rgba(255,69,162,0.66)',
          drawOutOfBound: true,
          textStyle: {
            normal: {
              color: function () {
                return 'rgb(' + [
                  Math.round(Math.random() * 160),
                  Math.round(Math.random() * 160),
                  Math.round(Math.random() * 160)
                ].join(',') + ')';
              },
              fontFamily: 'sans-serif',
              fontWeight: 'normal'
            },
            emphasis: {
              shadowBlur: 10,
            }
          },
          data: this.data
        }]
      };
      // 使用刚指定的配置项和数据显示图表。
      MyEcharts.setOption(option)
    }
  }
}
//'rgba(255,69,162,0.66)'
</script>
<style>
#all {
  width: 700px;
  height: 600px;
}
</style>