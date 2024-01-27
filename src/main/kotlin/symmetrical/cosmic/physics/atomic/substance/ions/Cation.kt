package symmetrical.cosmic.physics.atomic.substance.ions
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

import symmetrical.cosmic.physics.subatomic.luminescent.IMatter
import symmetrical.cosmic.physics.subatomic.luminescent.Matter

// For more information visit:  https://en.wikipedia.org/wiki/Ion#Anions_and_cations

class Cation(
    private val matterAntiMatter: IMatter = Matter().with(Cation::class),
) : Ion(),
    IMatter by matterAntiMatter
{
    override fun getClassId() : String {
        return matterAntiMatter.getClassId()
    }
    // plus
}