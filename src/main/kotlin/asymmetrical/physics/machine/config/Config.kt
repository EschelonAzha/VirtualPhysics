package asymmetrical.physics.machine.config
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




object Config {

    private const val  _PhotonLth             = 1;
    private const val  _ClassIdLth            = 2;
    private const val  _THREAD_SLEEP:Long     = 8;  // Milliseconds
    private const val  _UPDATE_SLEEP:Long     = 2;
    private const val BASE52_ARRAY_SIZE:Int   = 3;
    private const val PING:Long               = 200;

    fun getBase52ArraySize() : Int {
        return BASE52_ARRAY_SIZE
    }


    fun getClassIdLth() : Int {
        return _ClassIdLth
    }

    fun getPhotonLength() : Int {
        return _PhotonLth
    }
    fun getPing() : Long {
        return PING;
    }

    fun getThreadSleep() : Long {
        return _THREAD_SLEEP
    }
    fun getUpdateSleep() : Long {
        return _UPDATE_SLEEP
    }

}