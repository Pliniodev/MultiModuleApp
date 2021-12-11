package feature.newsapi.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.feature_newsapi.R
import com.example.feature_newsapi.databinding.ItemNewsApiArticleBinding
import feature.newsapi.domain.model.Article

internal class ArticlesAdapter(
    val action: (Article) -> Unit,
    val articles: List<Article>
) : RecyclerView.Adapter<ArticlesAdapter.ArticleHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleHolder {
        val binding = ItemNewsApiArticleBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return ArticleHolder(binding, onClick = { article -> action(article) })
    }

    override fun onBindViewHolder(holder: ArticleHolder, position: Int) {
        holder.bind(articles[position])
    }

    override fun getItemCount() = articles.size

    inner class ArticleHolder(
        private val binding: ItemNewsApiArticleBinding,
        private val onClick: (Article) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(article: Article) {
            binding.apply {
                title.text = article.title
                root.setOnClickListener { onClick(article) }
                Glide.with(root.context)
                    .load(article.urlToImage)
                    .placeholder(R.drawable.ic_baseline_portrait_24)
                    .into(binding.newsImage)
            }
        }
    }
}