metals = ["Aluminum", "Copper", "Lead", "Nickel", "Platinum", "Silver", "Tin"]
metals.reverse()
for i in metals:
    f = open(i.lower() + "_ingot_from_nuggets.json", "w")
    f.writelines(

        '''{
  "type": "minecraft:crafting_shaped",
  "pattern": [
    "###",
    "###",
    "###"
  ],
  "key": {
    "#": {
      "tag": "forge:nuggets/''' + i.lower() + '''"
    }
  },
  "result": {
    "item": "extensiveengineering:''' + i.lower() + '''_ingot"
  }
}'''

    )