export interface Job{
    jobPosId: number;
    description: string;
    minExp: number;
    minSal: number;
    maxSal: number;
    isActive: boolean;
    designation: string;
    createdBy: number;
    deadline: string;
    locations: string[];
    codingLanguages: string[];
}
 
export interface Location {
  locationId: number;
  name: string;
}
  
export interface CodingLanguage{
  languageId: number;
  langName: string;
  skill: string;
}
 
export interface Application{
  app_id?: number;
  employee_id: number;
  job_pos_id: number;
  verified_by_manager: boolean;
  status?: string;
}
 
 