package com.example.dogshelter.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.dogshelter.R
import com.example.dogshelter.data.model.Dog
import es.dmoral.toasty.Toasty

// der Adapter braucht den Context um auf String Resourcen zuzugreifen
// und die Liste an Jokes um sie für die RecyclerView vorzubereiten
class DogAdapter(
    private val context: Context,
    private val dataset: List<Dog>
) : RecyclerView.Adapter<DogAdapter.ViewHolder>() {
    // IDEE EINES VIEWHOLDERS
    // der ViewHolder weiß welche Teile des Layouts beim Recycling angepasst werden
    class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val dogImage = view.findViewById<ImageView>(R.id.dog_image)
        val dogName = view.findViewById<TextView>(R.id.dog_name)
        val dogAge = view.findViewById<TextView>(R.id.dog_age)
        val dogWeight = view.findViewById<TextView>(R.id.dog_weight)

        val adoptButton = view.findViewById<Button>(R.id.dog_adopt_button)
    }
    // ERSTELLEN DES VIEWHOLDERS
    // hier werden neue ViewHolder erstellt
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.dog_item, parent, false)
        return ViewHolder(adapterLayout)
    }
    // BEFÜLLEN DES VIEWHOLDERS
    // hier findet der Recyclingprozess statt
    // die vom ViewHolder bereitgestellten Parameter werden verändert
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dog = dataset[position]

        holder.dogImage.setImageResource(dog.imageResource)
        holder.dogName.text = dog.name
        holder.dogAge.text = "${dog.age} Monate"


        holder.adoptButton.setOnClickListener {
            Toast.makeText(context,"${dog.name} freut sich schon", Toast.LENGTH_SHORT)
                .show()
        }

    }
    // damit der LayoutManager weiß wie lang die Liste ist
    override fun getItemCount(): Int {
        return dataset.size
    }
}