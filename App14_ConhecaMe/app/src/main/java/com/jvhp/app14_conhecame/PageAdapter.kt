package com.jvhp.app14_conhecame

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class PageAdapter(gerenciador: FragmentManager):
FragmentPagerAdapter(gerenciador) {
        override fun getCount(): Int{
            return 4
        }

    override fun getItem(position: Int): Fragment {
        return if (position == 0)
            Fragment01()
        else if (position == 1)
            Fragment02()
        else if (position == 2)
            Fragment03()
        else
            Fragment04()
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return if (position == 0)
            "Sobre"
        else if (position == 1)
            "Formação"
        else if (position == 2)
            "Experiência"
        else
            "Diferencias"
    }

}