package com.example.lab3navigationlab.sreens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lab3navigationlab.adapter.FilmAdapter
import com.example.lab3navigationlab.databinding.FragmentListBinding
import com.example.lab3navigationlab.model.FilmModel


class FilmsListFragment : Fragment() {
    lateinit var binding: FragmentListBinding
    lateinit var adapter: FilmAdapter
    lateinit var recyclerView: RecyclerView



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initial()
    }

    private fun initial(){
        recyclerView = binding.rvFilm
        adapter = FilmAdapter(this)
        recyclerView.adapter = adapter
        adapter.setList(this.generateFilmsList())
    }

  private fun generateFilmsList(): ArrayList<FilmModel>{
        val filmsList=ArrayList<FilmModel>()

        val firstFilm = FilmModel("Один дома","https://upload.wikimedia.org/wikipedia/ru/0/03/Home_Alone_dvd_rus.jpg","У восьмилетнего Кевина большая семья, и с этим связано немало сложных моментов. На Рождество все собираются в Париж, но перед вылетом в страшной сумятице мальчика забывают дома. Как раз накануне Кевин загадывает желание — чтобы постоянно досаждающая ему семейка куда-нибудь исчезла, и наутро все случается именно так, как он хочет. Мальчик остается в совершенном одиночестве в огромном доме. Сначала он наслаждается своим положением, но потом...")
        filmsList.add(firstFilm)

        val secondFilm = FilmModel("Вышка","https://gidonline.io/img/6b0370f13_200x300.jpg","Бекки всегда любила заниматься экстремальными видами спорта, но после неожиданной гибели супруга приняла решение оставить свое рискованное занятие. В последний раз она вместе с подругой совершает опасное восхождение на шестисотметровую радиомачту, чтобы развеять прах умершего мужа. Девушкам придется вступить в противостояние со стихией, отчаянно надеясь на спасение.")
        filmsList.add(secondFilm)

        val thirdFilm = FilmModel("Мариуполь. Неутраченная надежда","https://s5.vcdn.biz/static/f/4981059131/image.jpg/pt/r300x423x4","Мариуполь, признанный в 2012 году одним из самых комфортных украинских городов, спустя десять лет стал смертельной ловушкой для местных жителей. Из-за российских бомбардировок и последующей оккупации мирное население своими глазами увидело ад на Земле. О том, с чем столкнулись мариупольцы в первый месяц вторжения агрессора, рассказывают создатели фильма, построенного на дневниках журналистки Надежды Сухоруковой и свидетельствах других очевидцев.")
        filmsList.add(thirdFilm)

        return filmsList
    }
}