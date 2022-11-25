<template>
  <center>
    <div>
      <h1>提问次数低于30次的技术</h1>
      <div id="lower"></div>
    </div>
  </center>
</template>

<script>
import {ParticlesBg} from "particles-bg-vue";
import * as echarts from "echarts";
import axios from "axios";

export default {
  name: "F_Lower",
  components: {
    // eslint-disable-next-line vue/no-unused-components
    ParticlesBg
  },
  data() {
    return {
      tag_name: [],
      tag_count: [],
    }
  },
  mounted() {
    axios.get("http://localhost:8000/lower").then(res => {
      const Lower = res.data
      const name = []
      const count = []
      // eslint-disable-next-line no-empty
      for (let i = 0; i < Lower.length; i++) {
        name.push(Lower[i]['tag_name'])
        count.push(Lower[i]['tag_count'])
      }
      this.tag_name = name
      this.tag_count = count
      this.Lower()
    })
  },
  methods: {
    Lower() {
      const MyEcharts = echarts.init(document.getElementById("lower"))
      const option = {
        title: {
          text: 'Technology'
        },
        tooltip: {
          trigger: 'axis'
        },
        grid: {
          left: '3%',
          right: '4%',
          bottom: '3%',
          containLabel: true
        },
        xAxis: {
          type: 'category',
          boundaryGap: false,
          data: this.tag_name,
          axisLabel: {
            interval: 0
          },
        },
        yAxis: {
          type: 'value'
        },
        series: [
          {
            name: 'Language',
            type: 'line',
            stack: 'Total',
            data: this.tag_count,
          },
        ]
      };
      MyEcharts.setOption(option)
    }
  }
}
</script>

<style scoped>
#lower {
  width: 1400px;
  height: 600px;
}
</style>