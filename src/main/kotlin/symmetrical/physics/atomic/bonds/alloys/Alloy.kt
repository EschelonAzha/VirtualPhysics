package symmetrical.physics.atomic.bonds.alloys
/*
 * This file is part of Virtual Physics.
 *
 * Copyright (C) [2024] Stephen R. DeSofi AKA Eschelon Azha
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

import symmetrical.physics.atomic.substance.Substance
import symmetrical.physics.subatomic.luminescent.IMatter
import symmetrical.physics.subatomic.luminescent.Matter

// For more information visit:  https://en.wikipedia.org/wiki/Alloy


open class Alloy(
    private val matterAntiMatter: IMatter = Matter().with(Alloy::class),
) :
    IMatter by matterAntiMatter
{

    var mixtures: Substance? = null
    var derived = ArrayList<Substance>()
    var mixture = ArrayList<Substance>()

    override fun getClassId() : String {
        return matterAntiMatter.getClassId()
    }

    fun getSubstance(pos:Int) : Substance {
        return this.mixture[pos]
    }

    open fun run() : Unit {
        println("I'm running");
    }
}