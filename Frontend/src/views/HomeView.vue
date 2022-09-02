<template>
  <div class="wrapper">
    <div class="options options-left">
      <h1 class="options-title">Registra tu equipo</h1>
      <input class="options-input" type="text" v-model="equipo" />
      <button class="options-btn" @click="registrarEquipos">Registrar</button>

      <table>
        <thead>
          <tr>
            <th>Equipo</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="equipo in listaEquipos" :key="equipo.id">
            <td>{{ equipo.name }}</td>
          </tr>
        </tbody>
      </table>
    </div>

    <div class="options options-right">
      <h1 class="options-title">Registra el marcador</h1>
      <form @submit.prevent="registrarPartido" class="options-form">
        <select
          id="equipolocal"
          class="options-select"
          v-model="partido.localTeam.id"
        >
          <option
            v-for="equipo in listaEquipos"
            :key="equipo.id"
            :value="equipo.id"
            class="options-input"
          >
            {{ equipo.name }}
          </option>
        </select>

        <input
          class="options-input"
          type="text"
          v-model="partido.goals_local"
        />

        <select
          id="equipoVisitante"
          class="options-select"
          v-model="partido.visitorTeam.id"
        >
          <option
            v-for="equipo in listaEquipos"
            :key="equipo.id"
            :value="equipo.id"
            class="options-input"
          >
            {{ equipo.name }}
          </option>
        </select>
        <input
          class="options-input"
          type="text"
          v-model="partido.goals_visitor"
        />
        <input class="options-date" type="date" v-model="partido.dateMatch" />

        <button class="options-btn" type="submit">Registrar</button>
      </form>
    </div>
  </div>
</template>

<script>
import axios from "axios";
export default {
  data() {
    return {
      equipo: "",
      partido: {
        user: {
          id: 1,
        },
        localTeam: {
          id: 0,
        },
        visitorTeam: {
          id: 0,
        },
        goals_local: 0,
        goals_visitor: 0,
        dateMatch: null,
      },

      listaEquipos: [],
    };
  },
  methods: {
    registrarEquipos() {
      axios
        .post("http://localhost:8080/api/teams", {
          name: this.equipo,
        })
        .then((response) => {
          this.listarEquipos();
          this.equipo = "";
          console.log(response);
        })
        .catch((error) => {
          console.log(error);
        });
    },

    listarEquipos() {
      axios
        .get("http://localhost:8080/api/teams")
        .then((response) => {
          this.listaEquipos = response.data;
          console.log(response.data, "Equipos");
        })
        .catch((error) => {
          console.log(error);
        });
    },

    registrarPartido() {
      console.log(this.partido);
      axios
        .post("http://localhost:8080/api/matches", this.partido)
        .then((response) => {
          console.log(response);
        })
        .catch((error) => {
          console.log(error);
        });
    },
  },

  mounted() {
    this.listarEquipos();
  },
};
</script>

<style lang="scss">
.wrapper {
  width: 100%;

  height: calc(100vh - 80px);
  display: flex;
  justify-content: center;
  align-items: center;

  .options {
    height: 100%;
    box-shadow: rgba(0, 0, 0, 0.16) 0px 10px 6px,
      rgba(0, 0, 0, 0.23) 0px 3px 6px;

    display: flex;
    flex-direction: column;
    justify-content: flex-start;
    align-items: center;

    &-left {
      width: 30%;
    }
    &-right {
      width: 70%;
    }
    &-title {
      font-size: 3rem;
      font-weight: bold;
      text-align: center;
      padding: 20px;
    }

    &-input,
    &-select {
      font-size: 32px;
      width: 80%;
      padding: 0.5rem;
      height: 50px;
      border: 1px solid #2c3e50;
      border-radius: 5px;
      margin: 0 auto 20px;
    }

    &-btn {
      width: 80%;
      height: 50px;
      border: 1px solid #2c3e50;
      border-radius: 5px;
      margin: 0 auto 20px;
      font-size: 1.5rem;
      font-weight: bold;
      color: #2c3e50;
      background-color: #42b983;
      cursor: pointer;
    }

    &-form {
      width: 80%;
      display: flex;
      flex-direction: column;
      justify-content: center;
      align-items: center;
    }

    &-date {
      width: 80%;
      height: 50px;
      border: 1px solid #2c3e50;
      border-radius: 5px;
      margin: 0 auto 20px;
      font-size: 1.5rem;
      font-weight: bold;
      color: #2c3e50;
      cursor: pointer;
    }
  }
}
</style>
