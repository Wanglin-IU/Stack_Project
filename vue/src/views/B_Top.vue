<template>
  <center>
    <div>
      <h1>技术提问量Top10</h1>
      <div id="top"></div>
    </div>
  </center>
</template>

<script>
import {ParticlesBg} from 'particles-bg-vue'
import axios from "axios";
import * as echarts from "echarts";

export default {
  // eslint-disable-next-line vue/multi-word-component-names
  name: 'B_Top',
  components: {
    // eslint-disable-next-line vue/no-unused-components
    ParticlesBg
  },
  data() {
    return {
      msg: [],
      value: [],
    }
  },
  mounted() {
    axios.get("http://localhost:8000/top").then(res => {
      // 读取接口请求成功回传回来的数据
      const Top_10 = res.data
      const posts = []
      const count = []
      for (let i = 0; i < Top_10.length; i++) {
        posts.push(Top_10[i]['tag_name'])
        count.push(Top_10[i]['sum_post'])
      }
      this.msg = posts
      this.value = count
      this.Top_10()
    })
  },
  methods: {
    Top_10() {
      const MyEcharts = echarts.init(document.getElementById("top"))
      const option = {
        tooltip: {
          trigger: 'axis',
          axisPointer: {
            type: 'shadow'
          }
        },
        grid: {
          left: '3%',
          right: '4%',
          bottom: '3%',
          containLabel: true
        },
        xAxis: [
          {
            show: true,
            type: 'category',
            data: this.msg,
            axisTick: {
              alignWithLabel: true
            },
            //刻度标签间隔
            axisLabel: {
              interval: 0
            },
          }
        ],
        yAxis: [
          {
            type: 'value'
          }
        ],
        axisLabel: {
          interval: 0,
        },
        series: [
          {
            name: 'Language',
            type: 'bar',
            barWidth: '60%',
            data: this.value,
            itemStyle: {
              color: 'rgba(255,194,126,0.31)',
            }
          }
        ]
      }
      MyEcharts.setOption(option)
    }
  }
}
</script>
<style>
#top {
  width: 1400px;
  height: 600px;
}
</style>