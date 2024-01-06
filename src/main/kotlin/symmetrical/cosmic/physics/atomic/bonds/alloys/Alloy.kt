package symmetrical.cosmic.physics.atomic.bonds.alloys
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

import symmetrical.cosmic.physics.atomic.substance.Substance
import symmetrical.cosmic.physics.subatomic.luminescent.IMatter
import symmetrical.cosmic.physics.subatomic.luminescent.Matter
/*
https://en.wikipedia.org/wiki/Alloy
 */

open class Alloy(
    val mixtures: Substance? = null,
    private val matter: IMatter = Matter(Alloy::class, Alloy::class),
) :
    IMatter by matter
{
    constructor() : this(
        null,
        Matter(Alloy::class, Alloy::class),
    )
    var derived = ArrayList<Substance>()
    var mixture = ArrayList<Substance>()

    init {
//        for (substance in mixtures) {
//            substance.addDerived(substance)
//            mixture.add(substance)
//        }
    }

    override fun getClassId() : String {
        return matter.getClassId()
    }

    fun getSubstance(pos:Int) : Substance {
        return this.mixture[pos]
    }

    open fun run() : Unit {
        println("I'm running");
    }
}