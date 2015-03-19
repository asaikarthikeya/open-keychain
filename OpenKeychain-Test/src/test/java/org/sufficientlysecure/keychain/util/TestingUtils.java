package org.sufficientlysecure.keychain.util;
/*
 * Copyright (C) 2014 Vincent Breitmoser <v.breitmoser@mugenguild.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

import java.util.Random;

public class TestingUtils {
    public static Passphrase genPassphrase() {
        return genPassphrase(false);
    }

    public static Passphrase genPassphrase(boolean noEmpty) {
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789!@#$%^&*()-_=";
        Random r = new Random();
        StringBuilder passbuilder = new StringBuilder();
        // 20% chance for an empty passphrase
        for(int i = 0, j = noEmpty || r.nextInt(10) > 2 ? r.nextInt(20)+1 : 0; i < j; i++) {
            passbuilder.append(chars.charAt(r.nextInt(chars.length())));
        }
        System.out.println("Generated passphrase: '" + passbuilder.toString() + "'");
        return new Passphrase(passbuilder.toString());
    }
}
