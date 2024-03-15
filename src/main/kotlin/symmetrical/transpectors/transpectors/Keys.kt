package symmetrical.transpectors.transpectors
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

import symmetrical.transpectors.printable_characters.Base52
import kotlinx.datetime.Clock
import symmetrical.dictionary.absorber.Absorber

object Keys {
    private var currentInstance = 1
    fun getUniqueId() : String {
        val galaxyId  :String  = Absorber.getGalaxyId()
        val longNumber:String  = Clock.System.now().toEpochMilliseconds().toString()
        val frontHalf :String  = Base52.toBase52(longNumber.substring(0, 7).toInt())
        val backHalf  :String  = Base52.toBase52(longNumber.substring(7).toInt())
        val instance  :String  = Base52.toBase52(nextInstance())
        val result    : String = galaxyId+frontHalf+backHalf+instance
        return result
    }
    private fun nextInstance() : Int {
        currentInstance++;
        return currentInstance
    }
}