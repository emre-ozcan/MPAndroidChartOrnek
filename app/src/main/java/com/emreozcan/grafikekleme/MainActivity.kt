package com.emreozcan.grafikekleme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.emreozcan.grafikekleme.databinding.ActivityMainBinding
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.*
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.github.mikephil.charting.utils.ColorTemplate

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root

        setContentView(view)

        val barEntry = arrayListOf<BarEntry>()
        val arabaModel = arrayOf("Egea","Clio","Megane","Corolla","Passat")

        barEntry.add(BarEntry(0f,50.116f))
        barEntry.add(BarEntry(1f,32.645f))
        barEntry.add(BarEntry(2f,24.562f))
        barEntry.add(BarEntry(3f,19.272f))
        barEntry.add(BarEntry(4f,16.111f))

        val barDataSet = BarDataSet(barEntry,"Satılan Arabalar")
        barDataSet.valueTextSize = 15f
        barDataSet.setColors(*ColorTemplate.MATERIAL_COLORS)

        val barData = BarData(barDataSet)
        binding.barChart.animateY(1500)
        binding.barChart.setFitBars(true)
        binding.barChart.data = barData
        binding.barChart.description.text = "Arabalar"
        binding.barChart.xAxis.valueFormatter = IndexAxisValueFormatter(arabaModel)
        binding.barChart.xAxis.position = XAxis.XAxisPosition.BOTTOM

        //PieChart
        val pieEntry = arrayListOf<PieEntry>()
        pieEntry.add(PieEntry(30f,"Egea"))
        pieEntry.add(PieEntry(20f,"Clio"))
        pieEntry.add(PieEntry(10f,"Megane"))
        pieEntry.add(PieEntry(5f,"Corolla"))
        pieEntry.add(PieEntry(2f,"Passat"))

        val pieDataSet = PieDataSet(pieEntry,"Araba Modelleri")
        pieDataSet.valueTextSize = 15f
        pieDataSet.setColors(*ColorTemplate.COLORFUL_COLORS)

        val pieData = PieData(pieDataSet)

        binding.pieChart.data = pieData
        binding.pieChart.description.text = "Arabalar"
        binding.pieChart.centerText = "Satılan Araba Modelleri"




    }
}