package cifor.icraf.objects.feature.ui.diffutil

import androidx.recyclerview.widget.DiffUtil
import cifor.icraf.objects.feature.data.models.Country

class ObjectDiffItemCallback : DiffUtil.ItemCallback<Country>() {

    override fun areItemsTheSame(oldItem: Country, newItem: Country): Boolean {
        return oldItem.countryId == newItem.countryId
    }

    override fun areContentsTheSame(oldItem: Country, newItem: Country): Boolean {
        return (oldItem == newItem)
    }

}