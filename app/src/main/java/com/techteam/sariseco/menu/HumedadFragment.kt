package com.techteam.sariseco.menu

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.techteam.sariseco.R
import com.techteam.sariseco.db.SensorData

class HumedadFragment : Fragment() {

    private lateinit var lineChart: LineChart
    private lateinit var database: DatabaseReference

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_humedad, container, false)

        lineChart = rootView.findViewById(R.id.lineChart)
        database = FirebaseDatabase.getInstance().reference.child("sensores/Historico")

        getSensorData()

        return rootView
    }

    private fun getSensorData() {
        // Escuchar los datos de Firebase
        database.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val sensorDataList = mutableListOf<SensorData>()
                for (sensorSnapshot in snapshot.children) {
                    val sensorData = sensorSnapshot.getValue(SensorData::class.java)
                    if (sensorData != null) {
                        sensorDataList.add(sensorData)
                    } else {
                        Log.d("FirebaseData", "SensorData es nulo para un nodo")
                    }
                }
                // Ordenar por fecha ascendente (más antigua a más actual)
                val sortedList = sensorDataList.sortedBy { it.fecha }
                val entries = mutableListOf<Entry>()
                var i = 0f
                for (sensorData in sortedList) {
                    entries.add(Entry(i++, sensorData.humedad))
                    Log.d("FirebaseData", "Humedad: ${sensorData.humedad}, Fecha: ${sensorData.fecha}")
                }

                // Crear un LineDataSet y establecer los valores del gráfico
                val dataSet = LineDataSet(entries, "Humedad")
                dataSet.setColor(Color.RED)  // Establecer color de la línea
                dataSet.setDrawValues(false)  // No dibujar valores en los puntos

                // Crear LineData
                val lineData = LineData(dataSet)
                lineChart.data = lineData
                lineChart.invalidate()  // Actualizar el gráfico
            }

            override fun onCancelled(error: DatabaseError) {
                // Manejar errores si la consulta falla
            }
        })
    }

}