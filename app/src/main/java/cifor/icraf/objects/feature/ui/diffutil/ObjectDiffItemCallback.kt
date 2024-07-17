package cifor.icraf.objects.feature.ui.diffutil

import androidx.recyclerview.widget.DiffUtil
import cifor.icraf.objects.feature.data.models.Object

class ObjectDiffItemCallback : DiffUtil.ItemCallback<Object>() {

    override fun areItemsTheSame(oldItem: Object, newItem: Object): Boolean {
        return oldItem.objectId == newItem.objectId
    }

    override fun areContentsTheSame(oldItem: Object, newItem: Object): Boolean {
        return (oldItem == newItem)
    }

}