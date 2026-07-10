<script setup>
import { ref } from 'vue'

const city = ref('Singapore')
const weather = ref(null)
const loading = ref(false)
const error = ref('')

async function searchWeather() {
  loading.value = true
  error.value = ''

  try {
    const response = await fetch(`http://localhost:8080/api/weather?city=${encodeURIComponent(city.value)}`)
    const data = await response.json()

    if (!response.ok) {
      throw new Error(data.detail || data.message || 'Unable to retrieve weather')
    }

    weather.value = data
  } catch (err) {
    error.value = err.message
  } finally {
    loading.value = false
  }
}
</script>

<template>
  <main class="page-shell">
    <section class="weather-card">
      <p class="eyebrow">SECOND INTERVIEW EXERCISE</p>
      <h1>Current weather</h1>
      <p class="intro">Search for a city to retrieve its current conditions through the local backend.</p>

      <form class="search-row" @submit.prevent="searchWeather">
        <label for="city">City</label>
        <div class="input-row">
          <input id="city" v-model="city" placeholder="e.g. Shanghai" />
          <button :disabled="loading">{{ loading ? 'Searching...' : 'Search' }}</button>
        </div>
      </form>

      <p v-if="error" class="error">{{ error }}</p>

      <section v-if="weather" class="results">
        <div class="result-heading">
          <div>
            <p class="muted">Resolved location</p>
            <h2>{{ weather.location }}</h2>
          </div>
          <strong>{{ weather.temperature }}°C</strong>
        </div>

        <dl>
          <div>
            <dt>Feels like</dt>
            <dd>{{ weather.apparentTemperature }}°C</dd>
          </div>
          <div>
            <dt>Wind</dt>
            <dd>{{ weather.windSpeed }} km/h</dd>
          </div>
          <div>
            <dt>Weather code</dt>
            <dd>{{ weather.weatherCode }}</dd>
          </div>
        </dl>
      </section>
    </section>
  </main>
</template>
