package cifor.icraf.objects.feature.ui.diffutil

import androidx.recyclerview.widget.DiffUtil

class ObjectDiffItemCallback : DiffUtil.ItemCallback<Object>() {

    override fun areItemsTheSame(oldItem: Object, newItem: Object): Boolean {
        return oldItem.objectId == newItem.objectId
    }

    override fun areContentsTheSame(oldItem: Object, newItem: Object): Boolean {
        return (oldItem == newItem)
    }

}