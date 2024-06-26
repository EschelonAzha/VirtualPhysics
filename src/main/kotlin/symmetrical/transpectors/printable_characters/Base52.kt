package symmetrical.transpectors.printable_characters
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


import asymmetrical.physics.machine.config.Config
import symmetrical.transpectors.transpectors.Strings
import kotlin.math.floor



class Base52() {

    object Static {
        public var UNIVERSE_ID      :String = "aaa"
        public var MAX_SESSIONS     :Int    = 70304
        // public var MAX_SESSIONS     :Int    = 3
        public var currentClassId   :String = "ba"
        public var currentGalaxyId  :String = UNIVERSE_ID
    }
    companion object {
        private val characters = Characters().with(LowerCase.LOWERCASE + UpperCase.UPPERCASE);


        fun classId() : String {
            var current  : String = Static.currentClassId
            Static.currentClassId = next(Static.currentClassId)
            return current
        }
        fun galaxyId() : String {
            var current   : String = Static.currentGalaxyId
            Static.currentGalaxyId = Strings.toFixedLength(Config.getGalaxyIdLth(), "a", next(Static.currentGalaxyId))
            if (toInt(Static.currentGalaxyId)>Static.MAX_SESSIONS) {
                println("Base52.galaxyId() *************** exceeded max sessions!!!!!!!!!!!!!!!!!!!!!!!")
                println("Base52.galaxyId() *************** exceeded max sessions!!!!!!!!!!!!!!!!!!!!!!!")
            }
            return current
        }


        fun next(base52: String): String {
            var value: Int = toInt(base52)
            return toBase52(++value)
        }

        fun toBase52(integer:Int) : String {
            var ones:Int        = (integer % 52.0).toInt();
            var quotient:Int    = floor(integer / 52.0).toInt();

            var base10      = ArrayList<Int>()
            base10.add(ones);
            while (quotient > 51) {
                ones          = (quotient % 52).toInt();
                quotient      = floor(quotient.toDouble()/52).toInt();
                base10.add(ones);
            }
            if (quotient != 0) {
                base10.add(quotient)
            }

            base10.reverse();
            var result = "";

            for (i in 0 until base10.size ) {
                result += characters.indexOf(base10[i]);
            }
            return result;
        }

        fun toFixedBase52(lth:Int, integer:Int) : String {
            val result = Strings.toFixedLength(lth, "a", toBase52(integer));
            return result;
        }
        fun toInt(base52:String) : Int {
            var base52 = Strings.trimLeading("a", base52);
            if (base52.isEmpty())
                return 0

            var result = 0;
            var pos    = 0;
            for (i in base52.length-1 downTo 0) {
                val character = base52[i]
                result += posValue(pos, character.toString())
                pos++;
            }
            return result;
        }
        private fun posValue(pos:Int, character:String) : Int {
            var value = characters.valueOf(character);
            for (i in 0 until pos) {
                value *= 52;
            }
            return value;
        }
    }

}