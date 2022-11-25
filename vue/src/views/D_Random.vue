<template>
  <center>
    <div>
      <h1>多维度分析:随机抽样</h1>
      <div id="random"></div>
    </div>
  </center>
</template>

<script>
import axios from "axios";
import * as echarts from "echarts";
import {ParticlesBg} from "particles-bg-vue";

export default {
  name: "D_Random",
  components: {
    // eslint-disable-next-line vue/no-unused-components
    ParticlesBg
  },
  data() {
    return {
      name: [],
      value: [],
    }
  },
  // 钩子函数 先执行接口调用后再执行methods中的方法
  mounted() {
    axios.get("http://localhost:8000/random").then(res => {
      // 读取接口请求成功回传回来的数据
      const Random = res.data
      const names = []
      const values = []
      for (let i = 0; i < Random.length; i++) {
        names.push(Random[i]['tag_name'])
        values.push(Random[i]['total_count'])
      }
      this.name = names
      this.value = values
      this.Random()
    })
  },
  methods: {
    Random() {
      const MyEcharts = echarts.init(document.getElementById("random"))
      const option = {
        tooltip: {
          trigger: 'axis',
          axisPointer: {
            type: 'shadow',
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
            data: this.name,
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
              color: 'rgba(255,128,190,0.3)',
            }
          }
        ]
      }
      MyEcharts.setOption(option)
    }
  }
}
</script>

<style scoped>
#random {
  width: 1400px;
  height: 600px;
}
</style>