<template>
  <center>
    <div>
      <h1>2021年1至5月技术的提问趋势</h1>
      <div id="smonth"></div>
    </div>
  </center>
</template>

<script>
import axios from "axios";
import * as echarts from "echarts";
import {ParticlesBg} from "particles-bg-vue";

export default {
  name: "E_SMonth",
  components: {
    // eslint-disable-next-line vue/no-unused-components
    ParticlesBg
  },
  data() {
    return {
      Y: [],
      Data_1: [],
      Data_2: [],
      Data_3: [],
      Data_4: [],
      Data_5: [],
    }
  },
  mounted() {
    axios.get("http://localhost:8000/smonth").then(res => {
      const Year = []
      const Data_1 = []
      const Data_2 = []
      const Data_3 = []
      const Data_4 = []
      const Data_5 = []
      // eslint-disable-next-line no-empty
      for (let x = 0; x < res.data.length; x++) {
        Year.push(res.data[x]['tag_name'])
      }
      //前五个标签
      this.Y = Year.filter(function (item, index) {
        return Year.indexOf(item) === index;
      })
      for (let i = 0; i <= 4; i++) {
        const x = {value: 0, name: ""};
        x.value = res.data[i]['post_count']
        x.name = res.data[i]['tag_name']
        Data_1.push(x)
      }
      for (let i = 5; i <= 9; i++) {
        const x = {value: 0, name: ""};
        x.value = res.data[i]['post_count']
        x.name = res.data[i]['tag_name']
        Data_2.push(x)
      }
      for (let i = 10; i <= 14; i++) {
        const x = {value: 0, name: ""};
        x.value = res.data[i]['post_count']
        x.name = res.data[i]['tag_name']
        Data_3.push(x)
      }
      for (let i = 15; i <= 19; i++) {
        const x = {value: 0, name: ""};
        x.value = res.data[i]['post_count']
        x.name = res.data[i]['tag_name']
        Data_4.push(x)
      }
      for (let i = 20; i <= 24; i++) {
        const x = {value: 0, name: ""};
        x.value = res.data[i]['post_count']
        x.name = res.data[i]['tag_name']
        Data_5.push(x)
      }
      this.Data_1 = Data_1
      this.Data_2 = Data_2
      this.Data_3 = Data_3
      this.Data_4 = Data_4
      this.Data_5 = Data_5
      this.SMonth()
    })
  },
  methods: {
    SMonth() {
      const MyEcharts = echarts.init(document.getElementById("smonth"))
      const option = {
        tooltip: {
          trigger: 'item',
          formatter: '{a} <br/>{b} : {c} ({d}%)'
        },
        legend: {
          left: 'center',
          top: 'bottom',
          data: this.Y,
        },
        series: [
          {
            name: '21-Apr',
            type: 'pie',
            radius: [20, 100],
            center: ['20%', '20%'],
            roseType: 'area',
            itemStyle: {
              borderRadius: 5
            },
            data: this.Data_1,
          },
          {
            name: '21-Feb',
            type: 'pie',
            radius: [20, 100],
            center: ['80%', '20%'],
            roseType: 'area',
            itemStyle: {
              borderRadius: 5
            },
            data: this.Data_2,
          },
          {
            name: '21-Jan',
            type: 'pie',
            radius: [20, 100],
            center: ['20%', '80%'],
            roseType: 'area',
            itemStyle: {
              borderRadius: 5
            },
            data: this.Data_3,
          },
          {
            name: '21-Mar',
            type: 'pie',
            radius: [20, 100],
            center: ['80%', '80%'],
            roseType: 'area',
            itemStyle: {
              borderRadius: 5
            },
            data: this.Data_4,
          },
          {
            name: '21-May',
            type: 'pie',
            radius: [20, 100],
            center: ['50%', '50%'],
            roseType: 'area',
            itemStyle: {
              borderRadius: 5
            },
            data: this.Data_5,
          }
        ]
      };
      MyEcharts.setOption(option)
    }
  }
}
</script>

<style scoped>
#smonth {
  width: 1400px;
  height: 600px;
}
</style>