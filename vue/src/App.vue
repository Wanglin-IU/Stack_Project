<template>
  <div class="id">
    <el-select v-model="value" class="m-2" size="large" @change="Page">
      <el-option v-for="item in options" :key="item.value" :label="item.label" :value="item.value"/>
    </el-select>
    <router-view/>
  </div>
</template>
<script>
export default {
  // eslint-disable-next-line vue/multi-word-component-names
  name: "App",
  data() {
    return {
      value: '',
      options: [
        {
          value: '/',
          label: '全部技术标签'
        },
        {
          value: 'Top10',
          label: '技术提问量Top10'
        },
        {
          value: 'C_Compare',
          label: '指定五项技术比较'
        },
        {
          value: 'D_Random',
          label: '多维度分析:随机抽样'
        },
        {        value: 'E_SMonth',
          label: '2021年技术的提问趋势'
        },
        {
          value: 'F_Lower',
          label: '提问次数低于30次的技术'
        },
      ]
    }
  },
  methods: {
    Page() {
      if (this.value === '/') {
        this.$router.push('/');
      } else if (this.value === 'Top10') {
        this.$router.push('/Top10');
      } else if (this.value === 'C_Compare') {
        this.$router.push('/Compare');
      } else if (this.value === 'D_Random') {
        this.$router.push('/Random');
      } else if (this.value === 'E_SMonth') {
        this.$router.push('/SMonth');
      } else if (this.value === 'F_Lower') {
        this.$router.push('/Lower');
      }
      this.$forceUpdate();
    }
  }
}
</script>
<style>
.id {
  text-align: left;
}
</style>