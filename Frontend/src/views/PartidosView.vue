<template>
  <div class="partidos">
    <h1>Partidos</h1>

    <table class="fixed_headers">
      <thead>
        <tr>
          <th>Equipo Local</th>
          <th>Goles local</th>
          <th>Equipo Visitante</th>
          <th>Goles visitante</th>
          <th>Fecha</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="partido in partidos" :key="partido.id">
          <td>{{ partido.localTeam.name }}</td>
          <td>{{ partido.goals_local }}</td>
          <td>{{ partido.visitorTeam.name }}</td>
          <td>{{ partido.goals_visitor }}</td>
          <td>{{ partido.dateMatch }}</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import axios from "axios";
export default {
  name: "partidosView",
  props: {
    msg: String,
  },

  data() {
    return {
      partidos: [],
    };
  },

  methods: {
    getPartidos() {
      axios
        .get("http://localhost:8080/api/matches")
        .then((response) => {
          console.log(response.data);
          this.partidos = response.data;
        })
        .catch((error) => {
          console.log(error);
        });
    },
  },

  created() {
    this.getPartidos();
  },

};
</script>

<style scoped lang="scss">
.fixed_headers {
  width: 100%;
  table-layout: fixed;
  border-collapse: collapse;

  th {
    text-align: center;
    text-decoration: underline;
  }
  thead {
    background-color: #333;
    color: #fdfdfd;
    tr {
      display: block;
      position: relative;
    }
  }
  tbody {
    display: block;
    overflow: auto;
    width: 100%;
    height: calc(100vh - 158px);
    tr {
      &:nth-child(even) {
        background-color: #ddd;
      }
    }
  }
}

.fixed_headers th,
.fixed_headers td {
  padding: 0.75rem;
  width: 25vw;
}
</style>
