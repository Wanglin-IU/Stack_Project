<template>
  <center>
    <div>
      <h1>指定五项技术比较</h1>
      <div id="compare"></div>
    </div>
  </center>
</template>

<script>
import {ParticlesBg} from 'particles-bg-vue'
import axios from "axios";
import * as echarts from "echarts";

export default {
  // eslint-disable-next-line vue/multi-word-component-names
  name: "C_Compare",
  components: {
    // eslint-disable-next-line vue/no-unused-components
    ParticlesBg
  },
  mounted() {
    axios.get("http://localhost:8000/compare").then(res => {
      // 读取接口请求成功回传回来的数据
      const Compare = res.data;
      // console.log(Appoint)
      // 定义数组，存放一会覆盖echarts图形的数据
      const data = [];
      // 循环遍历数组，取出数据，转成和data一样的格式
      for (let i = 0; i < Compare.length; i++) {
        const x = {name: '', value: 0};
        x.name = Compare[i]['tag_name']
        x.value = Compare[i]['total_count']
        // 往data数组中添加数据
        data.push(x)
      }
      // 覆盖data(){}中全局变量的数据
      this.data = data
      this.Compare()
    })
  },
  methods: {
    Compare() {
      const MyEcharts = echarts.init(document.getElementById("compare"))
      const option = {
        tooltip: {
          trigger: 'item'
        },
        legend: {
          top: '5%',
          left: 'center'
        },
        series: [
          {
            name: 'Language',
            type: 'pie',
            radius: ['40%', '70%'],
            avoidLabelOverlap: false,
            itemStyle: {
              borderRadius: 10,
              borderColor: '#fff',
              borderWidth: 2
            },
            label: {
              show: false,
              position: 'center'
            },
            emphasis: {
              label: {
                show: true,
                fontSize: '40',
                fontWeight: 'bold'
              }
            },
            labelLine: {
              show: false
            },
            data: this.data
          }
        ]
      }
      MyEcharts.setOption(option)
    }
  }
}
</script>
<style>
#compare {
  width: 1400px;
  height: 600px;
}
</style>