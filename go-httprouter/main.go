package main

import (
	"fmt"
	"io/ioutil"
	"log"
	"net/http"
	"os"
	"runtime"

	jsoniter "github.com/json-iterator/go"
	"github.com/julienschmidt/httprouter"
)

type jsonData struct {
	ID          int    `json:"id"`
	Description string `json:"description"`
}

func init() {
	runtime.GOMAXPROCS(runtime.NumCPU())
}

func filter(ss []jsonData, test func(jsonData) bool) (ret []jsonData) {
	for _, s := range ss {
		if test(s) {
			ret = append(ret, s)
		}
	}

	return
}

func readJSONFile(output *[]jsonData) {
	var json = jsoniter.ConfigCompatibleWithStandardLibrary

	jsonFile, err := os.Open("./data.json")

	if err != nil {
		log.Fatalf("unable to open json file")
	}

	byteValue, _ := ioutil.ReadAll(jsonFile)
	json.Unmarshal(byteValue, output)
}

func main() {
	var collection []jsonData
	readJSONFile(&collection)

	router := httprouter.New()
	router.GET("/", func(w http.ResponseWriter, r *http.Request, _ httprouter.Params) {
		description := r.URL.Query().Get("description")

		filtered := filter(collection, func(data jsonData) bool {
			return data.Description == description
		})

		w.Header().Set("Content-Type", "application/json")
		fmt.Fprint(w, filtered)
	})

	log.Fatal(http.ListenAndServe(":8080", router))
}
