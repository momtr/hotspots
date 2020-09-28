# Hotspots

## Routes

#### insert hotspot
- method: `POST`
- url: `/api/v1/hotspots`
- body: JSON; `name, longitude, latitude, [description, address, zip, city, phone, url, email, category]`
- headers: `Content-Type: application/json`

#### get close hotspots
- method: `GET`
- url: `/api/v1/hotspots`
- body: JSON; `{ longitude: Double, latitude: Double }`
- headers: `Content-Type: application/json`
- returns: `List<Hotspot>`

#### get hotspot by id
- method: `GET`
- url: `/api/v1/hotspots/{id}`
- path variable: id
- returns: `Hotspot`

#### get hotspot visits
- method: `GET`
- url: `/api/v1/hotspots/{id}/visits`
- path variable: id
- returns: `List<HotspotVisit>`

## Technology
- Java Spring
- MySQL

## Setup
- clone
- use your MySQL database settings in `application.properties`
- data aggregation / database population (`resources/locations.csv`)