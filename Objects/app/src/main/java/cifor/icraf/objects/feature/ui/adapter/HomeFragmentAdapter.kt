package cifor.icraf.objects.feature.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import cifor.icraf.objects.R
import cifor.icraf.objects.feature.ui.diffutil.ObjectDiffItemCallback

class HomeFragmentAdapter(
    private val onSubmitObjectButtonClicked: (String, String) -> Unit
) : ListAdapter<Object, HomeFragmentAdapter.ObjectItemViewHolder>(ObjectDiffItemCallback()) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ObjectItemViewHolder = ObjectItemViewHolder.inflateFrom(parent)

    override fun onBindViewHolder(holder: ObjectItemViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item = item)
        holder.submitObjectButton.setOnClickListener {
            onSubmitObjectButtonClicked(
                item.objectId,
                item.objectName
            )
        }
    }

    class ObjectItemViewHolder(rootView: CardView) : RecyclerView.ViewHolder(rootView) {

        private val objectIdValue = rootView.findViewById<TextView>(R.id.objectIdValue)

        private val objectNameValue = rootView.findViewById<TextView>(R.id.objectNameValue)

        val submitObjectButton: Button = rootView.findViewById(R.id.submitObjectButton)

        companion object {
            fun inflateFrom(viewGroup: ViewGroup): ObjectItemViewHolder {
                val layoutInflater = LayoutInflater.from(viewGroup.context)
                val view = layoutInflater.inflate(
                    R.layout.object_item,
                    viewGroup,
                    false
                ) as CardView
                return ObjectItemViewHolder(view)
            }
        }

        fun bind(item: Object) {
            objectIdValue.text = item.objectId
            objectNameValue.text = item.objectName
        }

    }

}