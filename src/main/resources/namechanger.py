import os

fin = open("E:/Coding Shiz/minecraft mods/My Mods/Ore-Shenanigans-1.15.2/src/main/resources/META-INF/mods.toml", "rt")
temp = fin.readlines()
fin.close()

fout = open("E:/Coding Shiz/minecraft mods/My Mods/Ore-Shenanigans-1.15.2/src/main/resources/META-INF/mods.toml", "wt")
for i in temp:
    fout.write(i.replace("extensiveengineering", "oreshenanigans"))
fout.close()
print("Instances Replaced")
