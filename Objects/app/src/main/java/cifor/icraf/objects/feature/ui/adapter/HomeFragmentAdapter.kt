package cifor.icraf.objects.feature.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import cifor.icraf.objects.R
import cifor.icraf.objects.feature.data.models.Country
import cifor.icraf.objects.feature.ui.diffutil.ObjectDiffItemCallback

class HomeFragmentAdapter : ListAdapter<Country, HomeFragmentAdapter.CountryItemViewHolder>(ObjectDiffItemCallback()) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CountryItemViewHolder = CountryItemViewHolder.inflateFrom(parent)

    override fun onBindViewHolder(holder: CountryItemViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item = item)
    }

    class CountryItemViewHolder(rootView: CardView) : RecyclerView.ViewHolder(rootView) {

        private val countryIdValue = rootView.findViewById<TextView>(R.id.countryIdValue)

        private val countryNameValue = rootView.findViewById<TextView>(R.id.countryNameValue)

        private val countryCurrencyValue = rootView.findViewById<TextView>(R.id.countryCurrencyValue)

        private val countryCodeValue = rootView.findViewById<TextView>(R.id.countryCodeValue)

        private val countryCountiesValue = rootView.findViewById<TextView>(R.id.countryCountiesValue)

        private val countryPhoneCodeValue = rootView.findViewById<TextView>(R.id.countryPhoneCodeValue)

        companion object {
            fun inflateFrom(viewGroup: ViewGroup): CountryItemViewHolder {
                val layoutInflater = LayoutInflater.from(viewGroup.context)
                val view = layoutInflater.inflate(
                    R.layout.country_item,
                    viewGroup,
                    false
                ) as CardView
                return CountryItemViewHolder(view)
            }
        }

        fun bind(item: Country) {
            countryIdValue.text = item.countryId.toString()
            countryNameValue.text = item.countryName
            countryCurrencyValue.text = item.countryCurrency
            countryCodeValue.text = item.countryCode
            countryCountiesValue.text = item.countryCounties.toString()
            countryPhoneCodeValue.text = item.countryPhoneCode
        }

    }

}