package symmetrical.physics.subatomic.matter.hadrons.mesons
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

import symmetrical.physics.subatomic.matter.quarks.Up
import symmetrical.physics.subatomic.balanced.pairs.ElectronPositron
import symmetrical.physics.subatomic.anti_matter.anti_hadrons.anti_mesons.AntiPlusPion
import symmetrical.physics.subatomic.anti_matter.anti_quarks.AntiDown
import symmetrical.physics.subatomic.luminescent.IMatter
import symmetrical.physics.subatomic.luminescent.Matter
import symmetrical.physics.subatomic.matter.hadrons.Hadron


// For more information visit:   https://en.wikipedia.org/wiki/Pion

open class PlusPion(
    private val matterAntiMatter: IMatter = Matter().with(PlusPion::class),
) : Hadron(),
    IMatter by matterAntiMatter
{
    // The plus pion binds Protons together by carrying the color
    // charge of one to the other
    init {
        super.capacity(2)
        this.set(0, Up())
        this.set(1, AntiDown())
    }

    override fun getClassId() : String {
        return matterAntiMatter.getClassId()
    }
//    fun decay() : ElectronPositron<PlusPion> {
//        return ElectronPositron<PlusPion>().decay(this)
//    }
    fun decay() : ElectronPositron {
        return ElectronPositron().decay(this)
    }
}