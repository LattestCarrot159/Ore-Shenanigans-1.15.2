import os

path = os.getcwd()

for root, dirs, files in os.walk(path):
    for file in files:
        filepath = root + os.sep + file
        
        if file.endswith((".json")):
            print(filepath)
            fin = open(filepath, "rt")
            temp = fin.readlines()
            fin.close()
            fout = open(filepath, "wt")
            for i in temp:
                fout.write(i.replace("extensiveengineering", "oreshenanigans"))
            fout.close()
            print("Instances Replaced")
