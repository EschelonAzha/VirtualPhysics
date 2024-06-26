package symmetrical.physics.atomic.atoms.states
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

import symmetrical.physics.atomic.atoms.Atom
import symmetrical.physics.atomic.atoms.elements.Hydrogen
import symmetrical.physics.subatomic.luminescent.IMatterAntiMatter
import symmetrical.physics.subatomic.luminescent.MatterAntiMatter
// Binary

class Binary(
    private val matterAntiMatter: IMatterAntiMatter = MatterAntiMatter().with(Binary::class),
) : Hydrogen(),
    IMatterAntiMatter by matterAntiMatter
{
    init {
        setBoolean(false)
    }

    override fun getClassId() : String {
        return matterAntiMatter.getClassId()
    }
    fun setBoolean(value:Boolean) : Binary {
        getField().setContent(value)
        return this
    }
}